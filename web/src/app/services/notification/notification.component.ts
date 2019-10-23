import { Component, OnInit, OnDestroy } from '@angular/core';
import { NotificationType, Notification } from './notification';
import { Subscription } from 'rxjs';
import { NotificationService } from './notification.service';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.scss']
})
export class NotificationComponent implements OnInit, OnDestroy {

  notifications: Notification[] = [];
  private subscription: Subscription;

  constructor(private notificationSvc: NotificationService) { }

private _addNotification(notification: Notification) {
    this.notifications.push(notification);

    if (notification.timeout !== 0) {
      setTimeout(() => this.close(notification), notification.timeout);

    }
  }

 ngOnInit() {
    this.subscription = this.notificationSvc.getObservable().subscribe(notification => this._addNotification(notification));
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

  close(notification: Notification) {
    this.notifications = this.notifications.filter(notif => notif.id !== notification.id);
  }


className(notification: Notification): string {

    let style: string;

    switch (notification.type) {

      case NotificationType.success:
        style = 'is-success';
        break;

      case NotificationType.warning:
        style = 'is-warning';
        break;

      case NotificationType.error:
        style = 'is-danger';
        break;

      default:
        style = 'is-info';
        break;
    }
    return style;
  }
}
