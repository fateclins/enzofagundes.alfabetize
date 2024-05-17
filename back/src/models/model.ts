import type { PgTable } from "drizzle-orm/pg-core";
import { db, schema } from "../../db/db";
import type { TableNames } from "../../db/schema";
import type { PostgresJsDatabase } from "drizzle-orm/postgres-js";
import { eq } from "drizzle-orm";

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
        return await this.db.insert(this.table).values(data).returning();
    }

    public async find(id: number): Promise<any>
    {
        return await this.db.select().from(this.table).where(eq((this.table as any).id, id));
    }

    public async all(): Promise<any>
    {
        return await this.db.select().from(this.table);
    }

    public async destroy(id: number): Promise<any>
    {
        return await this.db.delete(this.table).where(eq((this.table as any).id, id));
    }

    public async update(id: number, data: any): Promise<any>
    {
        return await this.db.update(this.table).set(data).where(eq((this.table as any).id, id));
    }
}

export default Model;