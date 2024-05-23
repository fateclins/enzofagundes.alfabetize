package com.example.alfabetize.domain.models

class Activity(private var id: Int, private var name: String, private var description: String, private var moduleId: Int)
{
    fun getId(): Int = id
    fun getName(): String = name
    fun getDescription(): String = description
    fun getModuleId(): Int = moduleId
}