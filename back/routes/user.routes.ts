import type { Router } from "express";
import UserController from "../src/controllers/user.controller";

const userController = new UserController();

export default function userRoutes (router: Router) {
    router.get('/users', async (req, res) => userController.index(req, res));
    router.get('/users/:id', async (req, res) => userController.show(req, res));
    router.post('/users', async (req, res) => userController.store(req, res));
    router.put('/users/:id', async (req, res) => userController.update(req, res));
    router.delete('/users/:id', async (req, res) => userController.destroy(req, res));
}