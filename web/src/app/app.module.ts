import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/layout/navbar/navbar.component';
import { HomeComponent } from './components/views/home/home.component';
import { FooterComponent } from './components/layout/footer/footer.component';
import { ModalComponent } from './components/layout/modal/modal.component';
import { LogsFormsComponent } from './components/views/forms/logs-forms/logs-forms.component';
import { LoginComponent } from './components/views/forms/login/login.component';
import { RegisterComponent } from './components/views/forms/register/register.component';
import { HttpClientModule } from '@angular/common/http';
import { DashboardComponent } from './components/views/dashboard/dashboard.component';
import { NavbarProfileComponent } from './components/layout/navbar-profile/navbar-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    FooterComponent,
    ModalComponent,
    LogsFormsComponent,
    LoginComponent,
    RegisterComponent,
    DashboardComponent,
    NavbarProfileComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
