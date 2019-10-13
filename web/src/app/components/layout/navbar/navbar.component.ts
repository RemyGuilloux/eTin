import { Component, OnInit, OnChanges, SimpleChanges, Input } from '@angular/core';
import { UserService } from '../../../services/user.service';
import { TokenStorageService } from 'src/app/services/auth/token-storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit, OnChanges {

  @Input()
  username = '';

  constructor(private userService: UserService, private token: TokenStorageService) { }

  info: any;
  isRegisterForm: boolean;

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.checkFormView();

    document.addEventListener('DOMContentLoaded', () => {

      // Get all "navbar-burger" elements
      const $navbarBurgers = Array.prototype.slice.call(document.querySelectorAll('.navbar-burger'), 0);

      // Check if there are any navbar burgers
      if ($navbarBurgers.length > 0) {

        // Add a click event on each of them
        $navbarBurgers.forEach( el => {
          el.addEventListener('click', () => {

            // Get the target from the "data-target" attribute
            const target = el.dataset.target;
            const $target = document.getElementById(target);

            // Toggle the "is-active" class on both the "navbar-burger" and the "navbar-menu"
            el.classList.toggle('is-active');
            $target.classList.toggle('is-active');

          });
        });
      }

    });
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

  ngOnChanges(changes: SimpleChanges) {
    this.username = this.userService.data;
    console.log(changes)
    console.log('NAVBAR: ' + this.username)
    // changes.prop contains the old and the new value...
  }

}
