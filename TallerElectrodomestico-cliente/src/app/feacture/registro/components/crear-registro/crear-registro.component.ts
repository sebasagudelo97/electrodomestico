import { Component, OnInit } from '@angular/core';
import { RegistroService } from '../../shared/service/registro.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { TipoElectrodomesticoService } from 'src/app/feacture/components/tipo-electrodomestico/service/tipo-electrodomestico.service';

const LONGITUD_MINIMA_PERMITIDA_TEXTO = 3;
const LONGITUD_MAXIMA_PERMITIDA_TEXTO = 30;
const SOLO_NUMEROS = '^[0-9]+$';
const LETRAS_MAYUSCULAS_MINUSCULAS_TILDES = '^[a-zA-ZáéíóúÁÉÍÓÚ ]*$';

@Component({
  selector: 'app-crear-registro',
  templateUrl: './crear-registro.component.html',
  styleUrls: ['./crear-registro.component.sass']
})
export class CrearRegistroComponent implements OnInit {

  registroForm: FormGroup;
  public tipoElectrodomestico: TipoElectrodomestico[];
  constructor(private servicioRegistro: RegistroService, private servicioTipoElectrodomestico: TipoElectrodomesticoService) { }

  ngOnInit(): void {
    this.listarElectrodomesticos();
    this.construirFormularioRegistro();
    console.log(this.listarElectrodomesticos());

  }

  public listarElectrodomesticos(): void {
    this.servicioTipoElectrodomestico.listarElectrodomestico().subscribe(
      tipoElectrodomesticos => this.tipoElectrodomestico = tipoElectrodomesticos
    )
  }

  public crearRegistro(): void {
    if (this.registroForm.valid) {
      this.servicioRegistro.guardar(this.registroForm.value)
        .subscribe(reserva => {
          Swal.fire({
            position: 'center',
            icon: 'success',
            title: 'Creación exitosa!',
            text: `La reserva se ha creado con exito`,
            showConfirmButton: true
          })
        })
    }
  }

  private construirFormularioRegistro(): void {
    this.registroForm = new FormGroup({
      nombreCliente: new FormControl('', [Validators.required,
                                          Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO),
                                          Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
                                          Validators.pattern(LETRAS_MAYUSCULAS_MINUSCULAS_TILDES)]),
      cedulaCliente: new FormControl('', [Validators.required,
                                          Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO),
                                          Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
                                          Validators.pattern(SOLO_NUMEROS)]),
      fechaIngreso: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required,
                                     Validators.maxLength(LONGITUD_MAXIMA_PERMITIDA_TEXTO),
                                     Validators.minLength(LONGITUD_MINIMA_PERMITIDA_TEXTO),
                                     Validators.pattern(SOLO_NUMEROS)]),
      tipoElectrodomestico: new FormControl('', [Validators.required])
    });
  }

  get formulario(){
    return this.registroForm.controls;
  }
}
