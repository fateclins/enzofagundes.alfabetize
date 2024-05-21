package com.example.alfabetize.models

class User {
    private var id: Int
    private var email: String
    private var password: String

    constructor(id: Int, email: String, password: String) {
        this.id = id
        this.email = email
        this.password = password
    }

    constructor() {
        this.id = 0
        this.email = ""
        this.password = ""
    }

    // Getters and setters

    public fun getId(): Int = id
    public fun getEmail(): String = email
    public fun getPassword(): String = password

    public fun setId(id: Int) {
        this.id = id
    }

    public fun setEmail(email: String) {
        this.email = email
    }

    public fun setPassword(password: String) {
        this.password = password
    }
}