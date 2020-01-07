import { Component, OnInit, Input } from '@angular/core';
import { AuthService } from 'src/app/services/oauth/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  @Input() loggedIn: boolean;

  ngOnInit(): void { }

  constructor(private authService: AuthService) { }

  logout = (): void => this.authService.logout();

}
