import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { SignUpInfo } from 'src/app/services/auth/signup-info';
import { TokenStorageService } from 'src/app/services/auth/token-storage.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  signupInfo: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  isLoggedIn: boolean;
  roles: string[] = [];
  isToggled = false;
  errorMessage = '';

  constructor(private authService: AuthService, private token: TokenStorageService) { }

  ngOnInit() {
    if (this.token.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.token.getAuthorities();
    }

    const dropdown = document.querySelector('.dropdown');
    dropdown.addEventListener('click', (event) => {
      event.stopPropagation();
      dropdown.classList.toggle('is-active');
    });

  }

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.name,
      this.form.username,
      this.form.email,
      this.form.password
      );

    this.authService.signUp(this.signupInfo).subscribe(
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


}
