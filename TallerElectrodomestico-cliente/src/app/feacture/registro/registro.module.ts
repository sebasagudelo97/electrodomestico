import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { RegistroRoutingModule } from './registro-routing.module';
import { CrearRegistroComponent } from './components/crear-registro/crear-registro.component';
import { ListarTodoRegistroComponent } from './components/listar-todo-registro/listar-todo-registro.component';
import { ListarSoloEntregaRegistroComponent } from './components/listar-solo-entrega-registro/listar-solo-entrega-registro.component';
import { RegistroService } from './shared/service/registro.service';
import { ActualizarRegistroComponent } from './components/actualizar-registro/actualizar-registro.component';


@NgModule({
  declarations: [CrearRegistroComponent, ListarTodoRegistroComponent, ListarSoloEntregaRegistroComponent, ActualizarRegistroComponent],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RegistroRoutingModule
  ],
  providers: [RegistroService]
})
export class RegistroModule { }
