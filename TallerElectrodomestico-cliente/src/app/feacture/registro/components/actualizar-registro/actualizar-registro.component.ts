import { Component, Input, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import Swal from 'sweetalert2';
import { Registro } from '../../shared/model/registro';
import { RegistroService } from '../../shared/service/registro.service';

const SOLO_NUMEROS = '^[0-9]+$';

@Component({
  selector: 'app-actualizar-registro',
  templateUrl: './actualizar-registro.component.html',
  styleUrls: ['./actualizar-registro.component.sass']
})
export class ActualizarRegistroComponent implements OnInit {

  registro: Registro;
  registroMuestra: Registro;
  tipoElectrodomestico: TipoElectrodomestico;
  registroForm: FormGroup;

  constructor(private registroService: RegistroService, private router: Router) {

  }

  ngOnInit(): void {
    this.registro = this.registroService.registro
    this.construirFormularioRegistro();
  }

  private construirFormularioRegistro(): void {
    this.registroMuestra = this.registro;
    this.registroForm = new FormGroup({
      nombreCliente: new FormControl(this.registro.nombreCliente, [Validators.required]),
      cedulaCliente: new FormControl(this.registro.cedulaCliente, [Validators.required]),
      fechaIngreso: new FormControl(this.registro.fechaIngreso, [Validators.required]),
      telefono: new FormControl(this.registro.telefono, [Validators.required]),
      tipoElectrodomestico: new FormControl(this.registro.tipoElectrodomestico, [Validators.required]),
      fechaSalida: new FormControl('', [Validators.required]),
      valorPagar: new FormControl('', [Validators.required,
      Validators.pattern(SOLO_NUMEROS)])
    });
    this.tipoElectrodomestico = this.registroForm.get('tipoElectrodomestico').value
  }

  get formulario() {
    return this.registroForm.controls;
  }

  actualizar(): void {
    if (this.registroForm.valid) {
      this.registroService.actualizar(this.registro.id, this.registroForm.value).subscribe(registro => {
        Swal.fire({
          position: 'center',
          icon: 'success',
          title: 'Actualizacion exitosa!',
          text: `La reserva se ha creado con exito`,
          showConfirmButton: true
        })
      });
    }

  }


}
