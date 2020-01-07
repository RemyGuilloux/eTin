import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable, BehaviorSubject } from 'rxjs';
import { config } from '../../config';
import { Token } from './token/token';
import { MatSnackBar } from '@angular/material';

import { Cookie } from 'ng2-cookies';
import { AuthLogin } from '../../models/users/forms/login.model';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  private readonly registerURI = config.apiURI + 'api/auth/signup';
  private readonly loginURI = config.apiURI + 'oauth/token';
  public loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>( Cookie.check('access_token') );

  constructor(protected router: Router, private http: HttpClient, private snackBar: MatSnackBar) {}

  logIn(data: AuthLogin): void {
    this.loadToken(data).subscribe(
      token => {
        this.saveToken( this.mapToken(token) );
        this.router.navigate(['/dashboard']);
        this.snackBar.open('Welcome Back ' + data.username, '', { duration: 3000 } );
      }, error => {
        const err = error.error.error;
        if (!!err) {
          if (err === 'unauthorized' || err === 'invalid_grant' ) {
            this.snackBar.open('These credentials doesn\'t seems right ... please check them 💪 ', '', { duration: 3000 } );
          }
      } else {
        this.snackBar.open('Seems like server is down, try again later 👻 ', '', { duration: 3000 } );
      }
      }
    );
  }

  signUp = (info: any): Observable<string> => this.http.post<string>(this.registerURI, info, config.httpOptions.json);

  saveToken = (token: Token): void => Cookie.set('access_token', token.accessToken, token.expiresIn);

  logout = (): void => {Cookie.delete('access_token'); this.router.navigate(['/welcome']); };

  getJwtToken = (): string => Cookie.get('access_token');

  isLoggedIn = (): boolean => {
    return Cookie.check('access_token')
  }

  private loadToken = (data: AuthLogin): Observable<any> => this.http.post<any>
    (this.loginURI, this.map(data), config.httpOptions.formUrlEncoded)

  private map = (data: AuthLogin): string => 'grant_type=' + config.grantType + '&username=' +
    data.username + '&password=' + data.password + '&client_id=' + config.clientId

  private mapToken = (token: any): Token => new Token(token.access_token, token.token_type,
    token.refresh_token, token.expires_in, token.scope, token.role, token.userId )

}
