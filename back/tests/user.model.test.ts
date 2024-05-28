import { test, expect, describe, beforeEach } from "bun:test";
import User from "../src/models/user.model";


describe('Testing the User model', () => {
    let user: User;
    let data: any;
    beforeEach(() => {
        user = new User();
        data = {
            email: `email${Date.now()}@example.com`,
            password: "12345678"
        };
    });

    test("Should be create a new user", async () => {
        const newUser = await user.create(data);

        expect(newUser[0]).toEqual({
            id: expect.any(Number),
            email: data.email,
            password: data.password
        });
    });

    test("Should be return all users", async () => {
        const users = await user.all();
        expect(users).toEqual(expect.any(Array));
    });

    test("Should be return a user by id", async () => {
        const users = await user.all();
        const userById = await user.find(users[0].id);

        expect(userById[0]).toEqual(users[0]);
    });

    test("Should be update a user", async () => {
        const users = await user.all();

        const updatedUser = await user.update(users[0].id, data);

        expect(updatedUser[0]).toEqual({
            id: users[0].id,
            email: data.email,
            password: data.password
        });
    });

    test("Should be delete a user", async () => {
        const users = await user.all();
        await user.destroy(users[0].id);
        const usersAfterDelete = await user.all();
        expect(usersAfterDelete).not.toContainEqual(users[0]);
    });

    test("Should be return a user with left join", async () => {
        const users = await user.all();
        const userWithLeftJoin = await user.leftJoin('profiles', 'id', users[0].id);
        expect(userWithLeftJoin).toContainEqual({
            users: expect.objectContaining({
                id: users[0].id,
                email: users[0].email,
                password: users[0].password
            }),
            profiles: null
        });
    });
});