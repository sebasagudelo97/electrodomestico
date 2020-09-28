import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RegistroRoutingModule } from './registro-routing.module';
import { CrearRegistroComponent } from './components/crear-registro/crear-registro.component';
import { ListarTodoRegistroComponent } from './components/listar-todo-registro/listar-todo-registro.component';
import { ListarSoloEntregaRegistroComponent } from './components/listar-solo-entrega-registro/listar-solo-entrega-registro.component';


@NgModule({
  declarations: [CrearRegistroComponent, ListarTodoRegistroComponent, ListarSoloEntregaRegistroComponent],
  imports: [
    CommonModule,
    RegistroRoutingModule
  ]
})
export class RegistroModule { }
