import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/views/home/home.component';
import { DashboardComponent } from './components/views/dashboard/dashboard.component';
import { RegisterComponent } from './components/views/forms/register/register.component';
import { LoginComponent } from './components/views/forms/login/login.component';

const routes: Routes = [
    {
      path: 'home',
      component: HomeComponent
    },
  {
    path: '',
    component: HomeComponent
},
{
  path: 'signup',
  component: HomeComponent
},
{
  path: 'signin',
  component: HomeComponent
},
{
    path: 'dashboard',
    component: DashboardComponent
},
// {path: '404', component: NotFoundComponent},
// {path: '**', redirectTo: '/404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
