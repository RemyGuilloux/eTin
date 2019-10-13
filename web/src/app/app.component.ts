import { Component, Input, Output, EventEmitter } from '@angular/core';
import { StatesService } from './services/states/states.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private states: StatesService) {

  }
  title = 'web';
  showModal: boolean = false;

  @Input()
  username = '';

  @Output() transfert = new EventEmitter();

  selectedItem(username) {
    this.showModal = false; // hide modal
    if (username) {
      this.username = username;
    }
    console.log("HOME"+username)
    this.transfert.emit(this.username);
  }
   openModal() {
      this.showModal = true;
   }
}
