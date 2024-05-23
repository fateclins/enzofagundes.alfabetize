import Controller from "./controller";
import Module from "../models/module.model";
import type { Request, Response } from "express";

class ModuleController extends Controller 
{
    constructor () {
        super(new Module());
    }

    public async index(req: Request, res: Response): Promise<void> {
        try {
            const modules = await this.model.all();
            res.status(200).json(modules);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }	

    public async show(req: Request, res: Response): Promise<void> {
        const id = req.params.id;

        try {
            const module = await this.model.find(id);
            res.status(200).json(module);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async store(req: Request, res: Response): Promise<void> {
        const data = req.body;

        try {
            const module = await this.model.create(data);
            res.status(201).json(module);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async update(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        const data = req.body;

        try {
            const module = await this.model.update(id, data);
            res.status(200).json(module);
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

export default ModuleController;