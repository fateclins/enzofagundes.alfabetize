import Model from "./model";

class Exercise extends Model {
    constructor() {
        super('exercises');
        this.fillable = ['question', 'answer'];
    }
}

export default Exercise;