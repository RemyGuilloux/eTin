import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StatesService {

  constructor() { }

    isModalToggled: boolean;

  isModalClosed() { return !this.isModalToggled; }
  toggleModal() { this.isModalToggled = this.isModalToggled === true ? false : true;  console.log(this.isModalClosed)}
}
