package com.example.alfabetize.models

class ActivityExercise(private var activityId: Int, private var exerciseId: Int)
{
    public fun getExerciseId(): Int = exerciseId
    public fun getActivityId(): Int = activityId

    public fun setExerciseId(exerciseId: Int)
    {
        this.exerciseId = exerciseId
    }

    public fun setActivityId(activityId: Int)
    {
        this.activityId = activityId
    }
}