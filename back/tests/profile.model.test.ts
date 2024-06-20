import { describe, it, beforeEach, expect } from "bun:test";
import Profile from "../src/models/profile.model";
import User from "../src/models/user.model";
interface IData {
    name: string;
    username: string;
    literacyLevel: string;
    xp: number;
    avatar: string;
    birthdate: Date;
    userId: number;
}

describe('Tests for Profile model', () => {
    let profile: Profile;
    let user: User;
    let data: IData;

    beforeEach(async () => {
        user = new User();
        const newUser = await user.create({
            email: `email${Date.now()}@example.com`,
            password: "12345678"
        });
    
        profile = new Profile();
        data = {
            name: 'John Doe',
            username: `john_doe_${Math.floor(Math.random() * 1000)}`,
            literacyLevel: 'beginner',
            xp: 0,
            avatar: 'avatar.jpg',
            birthdate: new Date('1990-01-01'),
            userId: newUser[0].id
        }
    })
    
    it('Should create a new profile ', async () => {
        const newProfile = await profile.create(data);
        const createdProfile = newProfile[0];
        expect(createdProfile).toMatchObject({
            id: expect.any(Number),
            name: data.name,
            username: data.username,
            literacyLevel: data.literacyLevel,
            xp: data.xp,
            avatar: data.avatar,
            birthdate: data.birthdate,
            userId: data.userId
        });
    });

    it('Should return a list of profiles', async () => {
        const profiles = await profile.all();
        expect(profiles).toBeInstanceOf(Array);
    });

    it('Should return a single profile', async () => {
        const newProfile = await profile.create(data);
        const createdProfile = newProfile[0];
        const foundProfile = await profile.find(createdProfile.id);
        expect(foundProfile[0]).toMatchObject({
            id: createdProfile.id,
            name: data.name,
            username: data.username,
            literacyLevel: data.literacyLevel,
            xp: data.xp,
            avatar: data.avatar,
            birthdate: data.birthdate,
            userId: data.userId
        });

        expect(foundProfile).toBeArrayOfSize(1);
    });

    it('Should update a profile ', async () => {
        const newProfile = await profile.create(data);
        const createdProfile = newProfile[0];
        const updatedProfile = await profile.update(createdProfile.id, { name: 'Jane Doe' });
        expect(updatedProfile[0]).toMatchObject({
            id: createdProfile.id,
            name: 'Jane Doe',
            username: data.username,
            literacyLevel: data.literacyLevel,
            xp: data.xp,
            avatar: data.avatar,
            birthdate: data.birthdate,
            userId: data.userId
        });
        
        expect(updatedProfile).toBeArrayOfSize(1); 
    });

    it('should delete a profile ', async () => {
        const newProfile = await profile.create(data);
        const createdProfile = newProfile[0];
        const deletedProfile = await profile.destroy(createdProfile.id);
        expect(deletedProfile).toBeArrayOfSize(0);
    });

    it('Should return a profile with a left join with users table', async () => {
        const newProfile = await profile.create(data);
        const createdProfile = newProfile[0];
        const profileWithUser = await profile.leftJoin('users', 'userId', data.userId.toString());
        expect(profileWithUser).toBeArray();
    });
});