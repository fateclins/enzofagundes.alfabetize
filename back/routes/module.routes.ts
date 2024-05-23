import { Router } from "express";
import ModuleController from "../src/controllers/module.controller";

const moduleController = new ModuleController();

export default function moduleRoutes (router: Router) {
    router.get('/modules', async (req, res) => moduleController.index(req, res));
    router.get('/modules/:id', async (req, res) => moduleController.show(req, res));
    router.post('/modules', async (req, res) => moduleController.store(req, res));
    router.put('/modules/:id', async (req, res) => moduleController.update(req, res));
    router.delete('/modules/:id', async (req, res) => moduleController.destroy(req, res));
}