import { PrismaClient } from "@prisma/client";

class Model
{
    protected prisma: PrismaClient;

    constructor()
    {
        this.prisma = new PrismaClient();
    }

    async disconnect()
    {
        await this.prisma.$disconnect();
    }

    getPrisma()
    {
        return this.prisma;
    }
}

export { Model };