import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Notification, NotificationType } from './notification';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private subject = new Subject<Notification>();
  private idx = 0;

  constructor() { }

  getObservable(): Observable<Notification> {
    return this.subject.asObservable();
  }

  info(message: string, timeout = 3000) {
    this.subject.next(new Notification(this.idx++, NotificationType.info, message, timeout));
  }

  success(message: string, timeout = 3000) {
    this.subject.next(new Notification(this.idx++, NotificationType.success, message, timeout));
  }

  warning(message: string, timeout = 3000) {
    this.subject.next(new Notification(this.idx++, NotificationType.warning, message, timeout));
  }

  error(message: string, timeout = 0) {
    this.subject.next(new Notification(this.idx++, NotificationType.error, message, timeout));
  }
}
