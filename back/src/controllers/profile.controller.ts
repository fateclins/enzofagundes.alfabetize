import Controller from "./controller";
import Profile from "../models/profile.model";
import type { Request, Response } from "express";

class ProfileController extends Controller {
    constructor() {
        super(new Profile());
    }

    public async index(req: Request, res: Response): Promise<void> {
        try {
            const profiles = await this.model.all();
            res.status(200).json(profiles);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async show(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        
        try {
            const profile = await this.model.leftJoin('users', 'user_id', 'id');
            res.status(200).json(profile);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async store(req: Request, res: Response): Promise<void> {
        const data = req.body;

        try {
            const profile = await this.model.create(data);
            res.status(201).json(profile);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async update(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        const data = req.body;

        try {
            const profile = await this.model.update(id, data);
            res.status(200).json(profile);
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

export default ProfileController;