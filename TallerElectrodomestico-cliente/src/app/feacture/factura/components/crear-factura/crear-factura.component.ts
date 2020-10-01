import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Registro } from 'src/app/feacture/registro/shared/model/registro';
import { RegistroService } from 'src/app/feacture/registro/shared/service/registro.service';
import Swal from 'sweetalert2';
import { FacturaService } from '../../shared/service/factura.service';
@Component({
  selector: 'app-crear-factura',
  templateUrl: './crear-factura.component.html',
  styleUrls: ['./crear-factura.component.sass'],
})
export class CrearFacturaComponent implements OnInit {

  registroForm: FormGroup;
  registro: Registro;
  fecha: Date;

  constructor(private registroService: RegistroService, private facturaService: FacturaService) { }

  ngOnInit(): void {
    this.registro = this.registroService.registro;
    this.construirFormularioRegistro();
  }

  private construirFormularioRegistro(): void{
    this.registroForm = new FormGroup({
      fechaActual: new FormControl(new Date(),[Validators.required]),
      registro: new FormControl(this.registro, Validators.required)
    });
    this.fecha = this.registroForm.get('fechaActual').value
  }

  public crearFactura(){
    this.facturaService.crearFactura(this.registroForm.value)
    .subscribe(reserva => {
      Swal.fire({
        position:'center',
        icon:'success',
        title:'Creación exitosa!',
        text:`La factura se ha creado con exito`,             
        showConfirmButton:true
      })
    })
  }

}
