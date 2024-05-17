import type { Router } from "express";
import User from "../src/models/user.model";

export default function userRoutes (router: Router) {
    router.get('/users', async (req, res) => {
        const user = new User();
        res.json(await user.all());
    })
}