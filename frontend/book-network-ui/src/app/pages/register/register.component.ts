import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { RegistrationRequest } from '../../services/models';
import { AuthenticationService } from '../../services/services';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent {

  registerRequest: RegistrationRequest = {
    email: '',
    firstname: '',
    lastname: '',
    password: ''
  };

  errorMsg: Array<String> = [];

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) { }

  register(): void {
    this.clearErrors();

    this.authService.register({ body: this.registerRequest }).subscribe({
      next: () => this.router.navigate(['activate-account']),
      error: (error) => this.handleError(error)
    });
  }

  login(): void {
    this.router.navigate(['login']);
  }

  private clearErrors(): void {
    this.errorMsg = [];
  }

  private handleError(error: any): void {
    console.error(error);

    if (error.error?.validationsErrors) {
      this.errorMsg = error.error.validationsErrors;
    } else if (error.error?.error) {
      this.errorMsg = [error.error.error];
    } else {
      this.errorMsg = ['Erro desconhecido ao realizar o registro.'];
    }
  }
}
