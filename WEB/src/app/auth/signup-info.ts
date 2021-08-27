export class SignUpInfo {
    name: string;
    username: string;
    email: string;
    role: string[];
    password: string; 
    cin:string;
    phone:string;

    constructor(name: string, username: string, email: string, password: string , cin: string, phone:string) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.cin= cin;
        this.phone= phone;
        this.role = ['user'];
    }
}
