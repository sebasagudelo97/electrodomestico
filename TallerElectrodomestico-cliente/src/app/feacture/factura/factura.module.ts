import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacturaRoutingModule } from './factura-routing.module';
import { ListarFacturaComponent } from './components/listar-factura/listar-factura.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FechaPipe } from './shared/pipe/fecha.pipe';


@NgModule({
  declarations: [ListarFacturaComponent, FechaPipe],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    FacturaRoutingModule
  ]
})
export class FacturaModule { }
