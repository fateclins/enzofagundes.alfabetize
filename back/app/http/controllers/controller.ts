import { Model } from "../../models/model";
import type { PrismaClient } from "@prisma/client";

class Controller
{
    protected model: Model = new Model;
    protected prisma: PrismaClient = this.model.getPrisma();
}

export { Controller };