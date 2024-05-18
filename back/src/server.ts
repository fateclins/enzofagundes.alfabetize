import express, { type Application } from 'express';
import routes from '../routes/api';

const app: Application = express();
const port: number | null = process.env.PORT ? parseInt(process.env.PORT) : null;

if (!port) {
    throw new Error('Port not found');
}

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use('/api/', routes);

export { app, port };