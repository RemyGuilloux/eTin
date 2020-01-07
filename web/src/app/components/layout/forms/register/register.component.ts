import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthService } from 'src/app/services/oauth/auth.service';
import { PasswordValidator } from '../../../../models/users/forms/validator/password.validator';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { FormFactory } from 'src/app/services/utils/form.factory';
import { RegisterInfo } from 'src/app/models/users/forms/register.model';
import { AuthLogin } from 'src/app/models/users/forms/login.model';
import { ParentErrorStateMatcher } from 'src/app/models/utils/error.options';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  encapsulation: ViewEncapsulation.None
})
export class RegisterComponent implements OnInit {

  constructor( private authService: AuthService, private fb: FormBuilder, private forms: FormFactory) {  }

  loading = false;

  protected registerForm: FormGroup;
  protected passwordForm: FormGroup;
  readonly errorMessages = this.forms.errorMessages;
  protected parentErrorStateMatcher = new ParentErrorStateMatcher();

  get username() { return this.registerForm.get('username'); }
  get email() { return this.registerForm.get('email'); }
  get password() { return this.passwordForm.get('password'); }
  get confirm() { return this.passwordForm.get('confirm'); }
  get agree() { return this.registerForm.get('agree'); }

  ngOnInit(): void { 
    this.passwordForm = this.forms.passwordForm;
    this.registerForm =  this.forms.registerForm;
  }

  register(): void {
      this.loading = true;
      this.authService.signUp(this.registerCredentials())
        .subscribe( () => this.authService.logIn(this.loginCredentials()),
          error => {
          const errors = error.error.errors;
          if ( !!errors ) {
            errors.forEach( ( err: any  ) => { console.log(err); } );
          }
        }
      );
      this.loading = false;
    }

  private registerCredentials = () => new RegisterInfo(this.username.value, this.email.value, this.password.value);

  private loginCredentials = () => new AuthLogin(this.username.value, this.password.value);

}
