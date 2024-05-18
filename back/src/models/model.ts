import type { PgTable } from "drizzle-orm/pg-core";
import { db, schema } from "../../db/db";
import type { SchemaNames } from "../../db/schema";
import type { PostgresJsDatabase } from "drizzle-orm/postgres-js";
import { eq } from "drizzle-orm";

class Model
{
    protected fillable: string[];
    protected db: PostgresJsDatabase = db;
    protected schema: PgTable<any>;
    protected table: string;

    constructor(tableName: SchemaNames, table: string)
    {
        this.fillable = [];
        this.schema = schema[tableName];
        this.table = table;
    }

    public async create(data: any): Promise<any>
    {
        return await this.db.insert(this.schema).values(data).returning();
    }

    public async find(id: number | string): Promise<any>
    {
        return await this.db.select().from(this.schema).where(eq((this.schema as any).id, id));
    }

    public async all(): Promise<any>
    {
        return await this.db.select().from(this.schema);
    }

    public async destroy(id: number | string): Promise<any>
    {
        return await this.db.delete(this.schema).where(eq((this.schema as any).id, id));
    }

    public async update(id: number | string, data: any): Promise<any>
    {
        return await this.db.update(this.schema).set(data).where(eq((this.schema as any).id, id));
    }

    public async leftJoin(table: string, column: string, condition: string): Promise<any>
    {
        const tableSchema = schema[table as SchemaNames];
        return await this.db.select().from(this.schema).leftJoin(tableSchema, eq((this.schema as any)[column], condition));
    }
}

export default Model;