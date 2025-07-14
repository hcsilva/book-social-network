import { Component } from '@angular/core';
import { AuthenticationRequest } from '../../services/models';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/services';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { TokenService } from '../../services/services/token/token.service';

@Component({
  selector: 'app-login',
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  authRequest: AuthenticationRequest = { email: '', password: '' };
  errorMsg: Array<String> = [];

  constructor(
    private router: Router,
    private authService: AuthenticationService,
    private tokenService: TokenService) { }

  login(): void {
    this.clearErrors();

    this.authService.authenticate({ body: this.authRequest }).subscribe({
      next: (res) => this.handleSuccess(res),
      error: (err) => this.handleError(err)
    });
  }

  private clearErrors(): void {
    this.errorMsg = [];
  }

  private handleSuccess(response: any): void {
    this.tokenService.token = response.token as string;
    this.router.navigate(['books']);
  }

  private handleError(error: any): void {
    console.error(error);

    if (error.error?.validationsErrors) {
      this.errorMsg = error.error.validationsErrors;
    } else if (error.error?.error) {
      this.errorMsg.push(error.error.error);
    } else {
      this.errorMsg.push('Erro desconhecido ao realizar login.');
    }
  }


  register() {
    this.router.navigate(['register']);
  }

}
