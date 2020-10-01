import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListarFacturaComponent } from './components/listar-factura/listar-factura.component';

const routes: Routes = [
  {path:'listar', component: ListarFacturaComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacturaRoutingModule { }
