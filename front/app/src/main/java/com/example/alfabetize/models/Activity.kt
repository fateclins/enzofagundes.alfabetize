package com.example.alfabetize.models

class Activity(private var id: Int, private var name: String, private var description: String, private var moduleId: Int)
{
    public fun getId(): Int = id
    public fun getName(): String = name
    public fun getDescription(): String = description
    public fun getModuleId(): Int = moduleId

    public fun setId() {
        this.id = id
    }

    public fun setName() {
        this.name = name
    }

    public fun setDescription() {
        this.description = description
    }

    public fun setModuleId() {
        this.moduleId = moduleId
    }
}