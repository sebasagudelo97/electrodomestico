import { Component, OnInit } from '@angular/core';
import { RegistroService } from '../../shared/service/registro.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import Swal from 'sweetalert2';
import { TipoElectrodomesticoService } from 'src/app/shared/service/tipo-electrodomestico.service';
import { TipoElectrodomestico } from 'src/app/shared/model/TipoElectrodomestico';

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

  public listarElectrodomesticos(): void{
    this.servicioTipoElectrodomestico.listarElectrodomestico().subscribe(
      tipoElectrodomesticos => this.tipoElectrodomestico = tipoElectrodomesticos
    )
  }

  public crearRegistro(): void{
    this.servicioRegistro.guardar(this.registroForm.value)
    .subscribe(reserva => {
      Swal.fire({
        position:'center',
        icon:'success',
        title:'Creación exitosa!',
        text:`La reserva se ha creado con exito`,             
        showConfirmButton:true
      })
    })
  }

  private construirFormularioRegistro(): void{
    this.registroForm = new FormGroup({
      nombreCliente: new FormControl('', [Validators.required]),
      cedulaCliente: new FormControl('', [Validators.required]),
      fechaIngreso: new FormControl('', [Validators.required]),
      telefono: new FormControl('', [Validators.required]),
      tipoElectrodomestico: new FormControl('', [Validators.required])
    });
  }
}
