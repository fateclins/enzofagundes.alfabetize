import type { Router } from "express";
import ProfileController from "../src/controllers/profile.controller";

const profileController = new ProfileController();

export default function profileRoutes (router: Router) {
    router.get('/profiles', async (req, res) => profileController.index(req, res));
    router.get('/profiles/:id', async (req, res) => profileController.show(req, res));
    router.post('/profiles', async (req, res) => profileController.store(req, res));
    router.put('/profiles/:id', async (req, res) => profileController.update(req, res));
    router.delete('/profiles/:id', async (req, res) => profileController.destroy(req, res));
}