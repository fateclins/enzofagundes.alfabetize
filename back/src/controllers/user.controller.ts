import Controller from "./controller";
import User from "../models/user.model";
import type { Request, Response } from "express";

class UserController extends Controller {
    constructor() {
        super(new User());
    }

    public async index(req: Request, res: Response): Promise<void> {
        try {
            const users = await this.model.all();
            res.status(200).json(users);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async show(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        
        try {
            const user = await this.model.find(id);
            res.status(200).json(user);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async store(req: Request, res: Response): Promise<void> {
        const data = req.body;

        try {
            const user = await this.model.create(data);
            res.status(201).json(user);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async update(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        const data = req.body;

        try {
            const user = await this.model.update(id, data);
            res.status(200).json(user);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async destroy(req: Request, res: Response): Promise<void> {
        const id = req.params.id;

        try {
            await this.model.destroy(id);
            res.status(204).json();
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }
}

export default UserController;