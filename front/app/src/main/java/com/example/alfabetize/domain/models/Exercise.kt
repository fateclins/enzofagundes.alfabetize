package com.example.alfabetize.domain.models

class Exercise(
    private var id: Int,
    private var question: String,
    private var answer: String
) {
    public fun getQuestion(): String = question
    public fun getAnswer(): String = answer
    public fun getId(): Int = id

    public fun setId() {
        this.id = id
    }

    public fun setQuestion() {
        this.question = question
    }

    public fun setAnswer() {
        this.answer = answer
    }
}