import Model from "./model";

class Profile extends Model {
    constructor() {
        super('profiles');
        this.fillable = [
            'name',
            'username',
            'literacy_level',
            'xp',
            'avatar',
            'birthdate',
            'user_id',
        ];
    }
}

export default Profile;