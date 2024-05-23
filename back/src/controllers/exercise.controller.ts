import Controller from "./controller";
import Exercise from "../models/exercise.model";
import type { Request, Response } from "express";

class ExerciseController extends Controller {
    constructor () {
        super(new Exercise());
    }

    public async index(req: Request, res: Response): Promise<void> {
        try {
            const exercises = await this.model.all();
            res.status(200).json(exercises);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async show(req: Request, res: Response): Promise<void> {
        const id = req.params.id;

        try {
            const exercise = await this.model.find(id);
            res.status(200).json(exercise);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async store(req: Request, res: Response): Promise<void> {
        const data = req.body;

        try {
            const exercise = await this.model.create(data);
            res.status(201).json(exercise);
        } catch (err: any) {
            res.status(500).json({ message: err.message });
        }
    }

    public async update(req: Request, res: Response): Promise<void> {
        const id = req.params.id;
        const data = req.body;

        try {
            const exercise = await this.model.update(id, data);
            res.status(200).json(exercise);
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

export default ExerciseController;