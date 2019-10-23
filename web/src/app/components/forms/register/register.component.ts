import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { RegisterInfo } from 'src/app/components/forms/register/register-info';
import { TokenStorageService } from 'src/app/services/auth/token/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  registerInfo: RegisterInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  isLoggedIn: boolean;
  roles: string[] = [];
  isToggled = false;
  errorMessage = '';

  constructor(private authService: AuthService, private token: TokenStorageService) { }

  ngOnInit() {
    this.isLoggedIn = this.checkLoggedIn();
  }

  onSubmit() {
    console.log(this.form);

    this.registerInfo = new RegisterInfo(
      this.form.userName,
      this.form.email,
      this.form.password,
      this.form.birthDate,
      );

    this.authService.signUp(this.registerInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
toggleDropDown() { this.isToggled =  this.isToggled === true ? false : true; }

  checkLoggedIn(): boolean {
    if (this.token.getToken()) {
      this.roles = this.token.getAuthorities();
      return true;
     } else { return false; }
  }

}
