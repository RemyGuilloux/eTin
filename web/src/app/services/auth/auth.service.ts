import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

import { JwtResponse } from './jwt-response';
import { AuthLoginInfo } from '../../components/forms/login/login-info';
import { RegisterInfo } from '../../components/forms/register/register-info';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginUrl = 'http://localhost:8081/auth/login';
  private signupUrl = 'http://localhost:8081/auth/register';

  constructor(private http: HttpClient) {
  }

  logIn(credentials: AuthLoginInfo): Observable<JwtResponse> {
    console.log(credentials)
    return this.http.post<JwtResponse>(this.loginUrl, credentials, httpOptions);
  }

  signUp(info: RegisterInfo): Observable<string> {
    return this.http.post<string>(this.signupUrl, info, httpOptions);
  }
}
