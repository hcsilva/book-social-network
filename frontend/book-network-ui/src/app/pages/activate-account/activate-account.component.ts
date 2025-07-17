import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CodeInputModule } from 'angular-code-input';
import { AuthenticationService } from '../../services/services';

@Component({
  selector: 'app-activate-account',
  standalone: true,
  imports: [FormsModule, CommonModule, CodeInputModule],
  templateUrl: './activate-account.component.html',
  styleUrl: './activate-account.component.scss'
})
export class ActivateAccountComponent {
  message = '';
  isOkay = true;
  submitted = false;

  private readonly successMessage =
    'Your account has been successfully activated.\nNow you can proceed to login.';
  private readonly errorMessage = 'Token has expired or is invalid.';

  constructor(
    private router: Router,
    private authService: AuthenticationService
  ) { }

  onCodeCompleted(event: any): void {
    const token = event as string;
    this.confirmActivationCode(token);
  }

  private confirmActivationCode(token: string): void {
    this.authService.confirm({ token }).subscribe({
      next: () => {
        this.message = this.successMessage;
        this.submitted = true;
        this.isOkay = true;
      },
      error: () => {
        this.message = this.errorMessage;
        this.submitted = true;
        this.isOkay = false;
      }
    });
  }

  redirectToLogin(): void {
    this.router.navigate(['login']);
  }
}
