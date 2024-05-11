import express from 'express';
import router from './routes/api';
import type { Request, Response } from 'express';
const app = express();
const port = 8080;

app.use(router);

app.get('/', (req: Request, res: Response) => {
  res.send('Hello, World!');
});

app.listen(port, () => {
  console.log(`Server started on http://localhost:${port}`);
});