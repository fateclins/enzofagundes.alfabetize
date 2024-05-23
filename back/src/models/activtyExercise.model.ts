import Model from "./model";

class ActivityExercise extends Model {
    constructor() {
        super('activityExercises');
        this.fillable = ['activity_id', 'exercise_id'];
    }
}

export default ActivityExercise;