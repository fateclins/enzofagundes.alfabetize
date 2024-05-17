import { pgTable, serial, text, varchar, integer, timestamp } from "drizzle-orm/pg-core";

export const users = pgTable('users', {
    id: serial('id').primaryKey(),
    email: varchar('email').unique(),
    password: text('password')
});

export const profiles = pgTable('profiles', {
    id: serial('id').primaryKey(),
    name: varchar('name', { length: 100}),
    username: varchar('username', { length: 100}).unique(),
    literacyLevel: varchar('literacy_level', { length: 100}),
    xp: integer('xp'),
    avatar: text('avatar'),
    birthdate: timestamp('birthdate'),
    userId: integer('user_id').references(() => users.id)
});

export const modules = pgTable('modules', {
    id: serial('id').primaryKey(),
    name: varchar('name', { length: 100})
});

export const activities = pgTable('activities', {
    id: serial('id').primaryKey(),
    name: varchar('name', { length: 100}),
    moduleId: integer('module_id').references(() => modules.id)
});

export const exercises = pgTable('exercises', {
    id: serial('id').primaryKey(),
    question: text('question'),
    answer: text('answer'),
});

export const activityExercises = pgTable('activity_exercises', {
    activityId: integer('activity_id').references(() => activities.id),
    exerciseId: integer('exercise_id').references(() => exercises.id)
});

export const schema = {
    users,
    profiles,
    modules,
    activities,
    exercises,
    activityExercises
};

export type TableNames = 'users' | 'profiles' | 'modules' | 'activities' | 'exercises' | 'activityExercises';