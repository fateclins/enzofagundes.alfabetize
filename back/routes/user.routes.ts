import UserController from "../app/http/controllers/user.controller";
import type { Router } from "express";

export default function userRoutes(router: Router) {
    const userController = new UserController();
    router.get("/users", (req, res) => userController.index(req, res));
    router.get("/users/:id", (req, res) => userController.show(req, res));
    router.post("/users", (req, res) => userController.store(req, res));
    router.put("/users/:id", (req, res) => userController.update(req, res));
    router.delete("/users/:id", (req, res) => userController.delete(req, res));
}