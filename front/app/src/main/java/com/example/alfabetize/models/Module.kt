package com.example.alfabetize.models

class Module(private var id: Int, private var name: String)
{
    public fun getId(): Int = id
    public fun getName(): String = name
    public fun setId(id: Int)
    {
        this.id = id;
    }
    public fun setName(name: String)
    {
        this.name = name;
    }

}