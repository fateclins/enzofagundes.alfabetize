import type { Request, Response } from "express";
import { Controller } from "./controller";

class UserController extends Controller
{
    public async index(req: Request, res: Response)
    {
        try
        {
            const users = await this.prisma.user.findMany();
            res.json(users);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async show(req: Request, res: Response)
    {
        const { id } = req.params;

        try
        {
            const user = await this.prisma.user.findUnique({
                where: {
                    id: parseInt(id)
                }
            });

            if (!user) {
                return res.status(404).json({ error: "User not found" });
            }

            res.json(user);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async store(req: Request, res: Response)
    {
        const { email, password } = req.body;
        
        try
        {
            const user = await this.prisma.user.create({
                data: {
                    email,
                    password
                }
            });

            res.json(user);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async update(req: Request, res: Response)
    {
        const { id } = req.params;
        const { email, password } = req.body;

        try
        {
            const user = await this.prisma.user.update({
                where: {
                    id: parseInt(id)
                },
                data: {
                    email,
                    password
                }
            });

            res.json(user);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async delete(req: Request, res: Response)
    {
        const { id } = req.params;

        try
        {
            await this.prisma.user.delete({
                where: {
                    id: parseInt(id)
                }
            });

            res.json({ message: "User deleted" });
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }
}

export default UserController;