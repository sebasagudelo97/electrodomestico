import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CrearRegistroComponent } from './components/crear-registro/crear-registro.component';
import { ListarSoloEntregaRegistroComponent } from './components/listar-solo-entrega-registro/listar-solo-entrega-registro.component';
import { ListarTodoRegistroComponent } from './components/listar-todo-registro/listar-todo-registro.component';

const routes: Routes = [
  {
    path: 'crear',
    component: CrearRegistroComponent
  },
  {
    path: 'listar-todo',
    component: ListarTodoRegistroComponent
  },
  {
    path: 'listar-entrega',
    component: ListarSoloEntregaRegistroComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RegistroRoutingModule { }
