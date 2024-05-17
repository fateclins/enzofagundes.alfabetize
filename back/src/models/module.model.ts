import Model from "./model";

class Module extends Model {
    constructor() {
        super('modules');
        this.fillable = ['name',];
    }
}

export default Module;