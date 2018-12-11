import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { AdminComponent } from './admin';
import { LoginGuard } from './guard';
import { GuestGuard, AdminGuard } from './guard';
import { NotFoundComponent } from './not-found';
import { ChangePasswordComponent } from './change-password';
import { ForbiddenComponent } from './forbidden';
import { SignupComponent } from './signup';
import { ExercisesComponent } from './exercises';
import { NewExerciseComponent } from './new-exercise';
 
export const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path:'signup',
    component: SignupComponent,
    canActivate: [GuestGuard],
    pathMatch:'full'
  },
  {
    path: 'exercises',
    component: ExercisesComponent,
    pathMatch: 'full',
    canActivate: [LoginGuard]
  },
  {
    path: 'exercises/new',
    component: NewExerciseComponent,
    pathMatch: 'full',
    canActivate: [AdminGuard],
  },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [GuestGuard]
  },
  {
    path: 'change-password',
    component: ChangePasswordComponent,
    canActivate: [LoginGuard]
  },
  {
    path: 'admin',
    component: AdminComponent,
    canActivate: [AdminGuard]
  },
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: '403',
    component: ForbiddenComponent
  },
  {
    path: '**',
    redirectTo: '/404'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }
