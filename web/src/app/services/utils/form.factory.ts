import { Validators, FormBuilder, FormGroup, FormControl } from '@angular/forms';
import { Injectable } from '@angular/core';
import { PasswordValidator } from '../../models/users/forms/validator/password.validator';

@Injectable({ providedIn: 'root' })
export class FormFactory {

    protected fb: FormBuilder = new FormBuilder();

    protected patterns = {
        telephone: /^\d{11}$/,
        username: /^[a-z\d]{5,12}$/i,
        password: '^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]+$',
        email: /^([a-z\d\.-]+)@([a-z\d-]+)\.([a-z]{2,8})(\.[a-z]{2,8})?$/
    };

    readonly errorMessages = {
        username: [
            { type: 'required', message: 'Username is required' },
            { type: 'minlength', message: 'Username must be at least 5 characters long' },
            { type: 'maxlength', message: 'Username cannot be more than 25 characters long' },
            { type: 'pattern', message: 'Your username must contain only numbers and letters' },
            { type: 'validUsername', message: 'Your username has already been taken' }
        ],
        email: [
            { type: 'required', message: 'Email is required' },
            { type: 'pattern', message: 'Enter a valid email ! expected: example@email.com' },
            { type: 'validUsername', message: 'Your email has already been taken' }
        ],
        confirm: [
            { type: 'areEqual', message: 'Passwords mismatch ! Try again' }
        ],
        password: [
            { type: 'required', message: 'Password is required' },
            { type: 'minlength', message: 'Password must be at least 5 characters long' },
            { type: 'pattern', message: 'Your password must contain at least one uppercase, one lowercase, and one number' }
        ],
        terms: [
            { type: 'pattern', message: 'You must accept terms and conditions' }
        ]
    };

    readonly loginForm: FormGroup = this.fb.group( {
        username: ['', [
        Validators.required,
        Validators.pattern(this.patterns.username)
        ]],
        password: ['', [
        Validators.required,
        Validators.pattern(this.patterns.password)
        ]]
    });

    readonly passwordForm = new FormGroup({
        password: new FormControl('', Validators.compose([
        Validators.required,
        Validators.pattern(this.patterns.password)
        ])),
        confirm: new FormControl('', Validators.required)
    }, (formGroup: FormGroup) => {
        return PasswordValidator.areEqual(formGroup);
    });

    readonly registerForm: FormGroup = this.fb.group({
        username: new FormControl('', Validators.compose([
            Validators.pattern(this.patterns.username),
            Validators.required
        ])),
        email: new FormControl('', Validators.compose([
            Validators.required,
            Validators.pattern(this.patterns.email)
        ])),
        passwordForm: this.passwordForm,
        agree: new FormControl(false, Validators.requiredTrue)
    });

}


