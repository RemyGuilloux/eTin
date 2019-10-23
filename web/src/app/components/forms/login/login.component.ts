import { Component, OnInit, OnChanges } from '@angular/core';
import { AuthLoginInfo } from 'src/app/components/forms/login/login-info';
import { TokenStorageService } from 'src/app/services/auth/token/token-storage.service';
import { AuthService } from 'src/app/services/auth/auth.service';
import { NotificationService } from '../../../services/notification/notification.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  username: string;
  private loginInfo: AuthLoginInfo;

  constructor(
    private authService: AuthService,
    private tokenStorage: TokenStorageService,
    protected notificationSvc: NotificationService,
    protected router: Router) { }

  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getAuthorities();
      this.username = this.tokenStorage.getUsername();
    }


  }

  onSubmit() {
    console.log(this.form);

    this.loginInfo = new AuthLoginInfo(
      this.form.username,
      this.form.password);

    this.authService.logIn(this.loginInfo).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUsername(data.username);
        this.tokenStorage.saveAuthorities(data.authorities);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getAuthorities();
        window.location.replace('/dashboard');
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.notificationSvc.error(this.errorMessage, 5000);
        this.isLoginFailed = true;
      }
    );
  }

  logout() {
    this.tokenStorage.signOut();
    window.location.replace('/');
  }

}
