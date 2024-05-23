import Model from "./model";

class Activity extends Model {
    constructor() {
        super('activities');
        this.fillable = ['name', 'description', 'module_id'];
    }
}

export default Activity;