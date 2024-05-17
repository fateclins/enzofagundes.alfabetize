import { Router } from "express";
import userRoutes from "./user.routes";

const routes = Router();
userRoutes(routes);

export default routes;