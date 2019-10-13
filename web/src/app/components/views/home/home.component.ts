import { Component, OnInit} from '@angular/core';
import { TokenStorageService } from 'src/app/services/auth/token-storage.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  info: any;
  isRegisterForm: boolean;

  constructor(private token: TokenStorageService) { }

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.checkFormView();
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
  toggleFormView(){
    this.isRegisterForm = !this.isRegisterForm;
  }

  checkFormView() {
    this.isRegisterForm =  window.location.pathname.includes('signup') ? true : false;
  }

}
