import type { Request, Response } from "express";
import { Controller } from "./controller";

class ProfileController extends Controller
{
    public async index(req: Request, res: Response)
    {
        try
        {
            const profiles = await this.prisma.profile.findMany();
            res.json(profiles);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async show(req: Request, res: Response)
    {
        const { id } = req.params;

        try
        {
            const profile = await this.prisma.profile.findUnique({
                where: {
                    id: parseInt(id)
                }
            });

            if (!profile) {
                return res.status(404).json({ error: "Profile not found" });
            }

            res.json(profile);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async store(req: Request, res: Response)
    {
        const {
            name,
            username,
            literacy_level,
            xp,
            avatar,
            birthday,
            userId,
        } = req.body;

        try
        {
            const profile = await this.prisma.profile.create({
                data: {
                    name,
                    username,
                    literacy_level,
                    xp,
                    avatar,
                    birthday,
                    userId,
                }
            });

            res.json(profile);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async update(req: Request, res: Response)
    {
        const { id } = req.params;
        const {
            name,
            username,
            literacy_level,
            xp,
            avatar,
            birthday,
            userId,
        } = req.body;

        try
        {
            const profile = await this.prisma.profile.update({
                where: {
                    id: parseInt(id)
                },
                data: {
                    name,
                    username,
                    literacy_level,
                    xp,
                    avatar,
                    birthday,
                    userId,
                }
            });

            res.json(profile);
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }

    public async delete(req: Request, res: Response)
    {
        const { id } = req.params;

        try
        {
            await this.prisma.profile.delete({
                where: {
                    id: parseInt(id)
                }
            });

            res.json({ message: "Profile deleted" });
        } catch (error) {
            res.status(500).json({ error: "Internal server error" });
        }
    }
}

export default ProfileController;