import { drizzle } from 'drizzle-orm/postgres-js';
import { migrate } from 'drizzle-orm/postgres-js/migrator';
import postgres from 'postgres';

const connectionString = process.env.DATABASE_URL;

if (!connectionString) {
  throw new Error('DATABASE_URL is not defined');
}

const migrationClient = postgres(connectionString, { max: 1 }); // Use max: 1 for migrations
const db = drizzle(migrationClient);

async function runMigrations() {
  await migrate(db, { migrationsFolder: 'drizzle' });
  await migrationClient.end();
}

runMigrations();