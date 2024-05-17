import { defineConfig } from 'drizzle-kit';

// export default defineConfig({
//   schema: './db/schema.ts',
//   out: './drizzle',
//   dialect: 'postgresql',
// });

// import { defineConfig } from 'drizzle-kit'
const connectionString: string | undefined = process.env.DATABASE_URL

if (!connectionString) {
    throw new Error('DATABASE_URL is not defined')
}

export default defineConfig({
  schema: './db/schema.ts', // specify your schema file
  out: './drizzle', // specify the output directory
  dialect: 'postgresql', // specify your dialect
  dbCredentials: {
    url: connectionString, // your PostgreSQL connection string
  },
});