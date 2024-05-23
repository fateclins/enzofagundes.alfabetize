import { Router } from "express";
import ExerciseController from "../src/controllers/exercise.controller";

const exerciseController = new ExerciseController();

export default function exerciseRoutes (router: Router) {
    router.get('/exercises', async (req, res) => exerciseController.index(req, res));
    router.get('/exercises/:id', async (req, res) => exerciseController.show(req, res));
    router.post('/exercises', async (req, res) => exerciseController.store(req, res));
    router.put('/exercises/:id', async (req, res) => exerciseController.update(req, res));
    router.delete('/exercises/:id', async (req, res) => exerciseController.destroy(req, res));
}