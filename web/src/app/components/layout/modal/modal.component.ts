import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.scss']
})
export class ModalComponent implements OnInit {

  @Input()
  username = '';

  // tslint:disable-next-line: no-output-on-prefix
  @Output() onClose = new EventEmitter();

  constructor(private userService: UserService) {

  }

  ngOnInit() {
  }

  cancel() { this.onClose.emit(null); }

  selectedItem() {
    this.userService.data = this.username
    console.log('selecting....' + this.userService.data);
    this.onClose.emit(null);
  }

}
