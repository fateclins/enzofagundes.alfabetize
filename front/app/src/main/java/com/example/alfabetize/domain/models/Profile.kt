package com.example.alfabetize.domain.models

class Profile
{
    private var id: Int
    private var name: String
    private var username: String
    private var literacyLevel: String
    private var xp: Int
    private var avatar: String
    private var birthdate: String
    private var userId: Int

    constructor(id: Int, name: String, username: String, literacyLevel: String, xp: Int, avatar: String, birthdate: String, userId: Int)
    {
        this.id = id
        this.name = name
        this.username = username
        this.literacyLevel = literacyLevel
        this.xp = xp
        this.avatar = avatar
        this.birthdate = birthdate
        this.userId = userId
    }

    public fun getId(): Int = id
    public fun getName(): String = name
    public fun getUsername(): String = username
    public fun getLiteracyLevel(): String = literacyLevel
    public fun getXp(): Int = xp
    public fun getAvatar(): String = avatar

    public fun setId(id: Int)
    {
        this.id = id
    }

    public fun setName(name: String) {
        this.name = name
    }

    public fun setUsername(username: String) {
        this.username = username
    }

    public fun setLiteracyLevel(literacyLevel: String) {
        this.literacyLevel = literacyLevel
    }

    public fun setXp(xp: Int) {
        this.xp = xp
    }

    public fun setAvatar(avatar: String) {
        this.avatar = avatar
    }

    public fun setBirthdate(birthdate: String) {
        this.birthdate = birthdate
    }

    public fun setUserId(userId: Int) {
        this.userId = userId
    }
}