import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './feacture/components/home/home.component';

const routes: Routes = [
  {
    path: 'home', component: HomeComponent
  },
  {
    path: 'registro', loadChildren: () => import('./feacture/registro/registro.module').then(mod => mod.RegistroModule)
  },
  {
    path: '', redirectTo: 'home', pathMatch: 'full'
  },
  {
    path: '**', redirectTo: 'home', pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
