import { Router } from "express";
import ActivityController from "../src/controllers/activity.controller";

const activityController = new ActivityController();

export default function activityRoutes (router: Router) {
    router.get('/activities', async (req, res) => activityController.index(req, res));
    router.get('/activities/:id', async (req, res) => activityController.show(req, res));
    router.post('/activities', async (req, res) => activityController.store(req, res));
    router.put('/activities/:id', async (req, res) => activityController.update(req, res));
    router.delete('/activities/:id', async (req, res) => activityController.destroy(req, res));
}