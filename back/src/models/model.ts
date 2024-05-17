import type { PgTable } from "drizzle-orm/pg-core";
import { db, schema } from "../../db/db";
import type { TableNames } from "../../db/schema";
import type { PostgresJsDatabase } from "drizzle-orm/postgres-js";

class Model
{
    protected fillable: string[];
    protected db: PostgresJsDatabase = db;
    protected table: PgTable<any>;

    constructor(tableName: TableNames)
    {
        this.fillable = [];
        this.table = schema[tableName];
    }

    public async create(data: any): Promise<any>
    {
        const query = await this.db.insert(this.table).values(data).returning();
        return query;
    }

    public async all(): Promise<any>
    {
        const query = await this.db.select().from(this.table);
        return query;
    }

    public async find(id: number | string | any): Promise<any>
    {
        const query = await this.db.select({ id: id }).from(this.table);
        return query;
    }
}

export default Model;