import { Component } from '@angular/core';
import { AuthService } from '../services/oauth/auth.service';
import { config } from '../config';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  readonly title = config.title;

  constructor(private authService: AuthService) {}

  isLoggedIn(): boolean { return this.authService.isLoggedIn(); }

}
