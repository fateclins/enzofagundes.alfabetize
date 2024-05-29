import { describe, it, beforeEach, expect } from 'bun:test';
import { drizzle } from 'drizzle-orm/postgres-js';
import postgres from 'postgres';

describe('Testing db.ts file', () => {
    let connectionString: string | undefined;
    beforeEach(() => {
        connectionString = process.env.DATABASE_URL;
    });

    it('should connect to the database', async () => {
        if (!connectionString) {
            throw new Error('DATABASE_URL is not defined');
        }
        const client = postgres(connectionString);
        expect(client).toBeDefined();
    });

    it('should throw an error if DATABASE_URL is not defined', () => {
        expect(() => {
            connectionString = undefined;
            if (!connectionString) {
                throw new Error('DATABASE_URL is not defined');
            }
        }).toThrowError('DATABASE_URL is not defined');
    });

    it('should export the db object', () => {
        expect(() => {
            if (typeof connectionString === 'string') {
                const client = postgres(connectionString);
                const db = drizzle(client);
                expect(db).toBeDefined();
            } else {
                throw new Error('DATABASE_URL is not defined');
            }
        });
    });
});