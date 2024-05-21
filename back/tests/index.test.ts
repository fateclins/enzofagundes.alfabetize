import { expect, describe, test } from "bun:test";
import request from "supertest";
import { app } from "../src/server";

describe("Testing the index file", () => {
    test("Should be return Hello World", async () => {
        const response = await request(app).get("/api");
        expect(response.status).toBe(200);
        expect(response.body).toEqual({ message: "Hello, world!" });
    });

    test("Should be return all users", async () => {
        const response = await request(app).get("/api/users");
        expect(response.status).toBe(200);
        expect(response.body).toEqual({ users: [{}] });
    });
});