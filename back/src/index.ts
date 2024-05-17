import express, { type Application } from 'express';
import routes from '../routes/api';
const app: Application = express();
const port: number = 3000;

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use('/api/', routes);

const start = async () => {
    try {
        app.listen(port, () => {
            console.log(`Server is running on port ${port}`);
        });
    } catch (error) {
        console.error(error);
    }
}

start();