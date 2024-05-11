import { Router } from "express";

import userRoutes from "./user.routes";
import profileRoutes from "./profile.routes";

const router = Router();

userRoutes(router);
profileRoutes(router);

export default router;