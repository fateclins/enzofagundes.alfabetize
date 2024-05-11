import ProfileController from "../app/http/controllers/profile.controller";
import type { Router } from "express";

export default function profileRoutes(router: Router) {
    const profileController = new ProfileController();
    router.get("/profiles", (req, res) => profileController.index(req, res));
    router.get("/profiles/:id", (req, res) => profileController.show(req, res));
    router.post("/profiles", (req, res) => profileController.store(req, res));
    router.put("/profiles/:id", (req, res) => profileController.update(req, res));
    router.delete("/profiles/:id", (req, res) => profileController.delete(req, res));
}