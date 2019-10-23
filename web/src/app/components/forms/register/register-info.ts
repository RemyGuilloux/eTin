export class RegisterInfo {
    userName: string;
    email: string;
    password: string;
    birthDate: Date;
    role: string[];

    constructor(userName: string, email: string, password: string, birthDate: Date) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.role = ['user'];
        this.birthDate = birthDate;
  }
}
