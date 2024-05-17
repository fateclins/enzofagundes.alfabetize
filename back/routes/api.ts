import { Router } from "express";
import userRoutes from "./user.routes";

const routes = Router();
routes.get("/", (req, res) => res.status(200).json({ message: "Hello, world!" }));
userRoutes(routes);

export default routes;