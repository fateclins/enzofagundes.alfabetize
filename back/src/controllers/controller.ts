import type Model from "../models/model";

class Controller {
    protected model: Model;

    constructor(model: Model) {
        this.model = model;
    }
}

export default Controller;