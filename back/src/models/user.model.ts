import Model from "./model";

class User extends Model {
    constructor() {
        super('users');
        this.fillable = ['email', 'password'];
    }
}

export default User;