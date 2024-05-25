import { Router } from "express";
import userRoutes from "./user.routes";
import activityRoutes from "./activity.routes";
import exerciseRoutes from "./exercise.routes";
import profileRoutes from "./profile.routes";
import moduleRoutes from "./module.routes";

const routes = Router();

routes.get("/", (req, res) => res.status(200).json({ message: "Hello, world!" }));

userRoutes(routes);
activityRoutes(routes);
exerciseRoutes(routes);
profileRoutes(routes);
moduleRoutes(routes);
export default routes;