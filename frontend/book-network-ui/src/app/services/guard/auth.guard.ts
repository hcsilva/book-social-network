import { inject } from '@angular/core';
import { TokenService } from './../services/token/token.service';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = () => {
  const tokenService: TokenService = inject(TokenService);
  const router: Router = inject(Router);
  
  if (tokenService.isTokenNotValid()) {
    router.navigate(['login']);
    return false;
  }

  return true;
};
