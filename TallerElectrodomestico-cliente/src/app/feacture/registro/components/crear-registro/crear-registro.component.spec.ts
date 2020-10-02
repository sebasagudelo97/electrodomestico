import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/services/http.service';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { TipoElectrodomesticoService } from 'src/app/feacture/components/tipo-electrodomestico/service/tipo-electrodomestico.service';
import { RegistroService } from '../../shared/service/registro.service';

import { CrearRegistroComponent } from './crear-registro.component';

describe('CrearRegistroComponent', () => {
  let component: CrearRegistroComponent;
  let fixture: ComponentFixture<CrearRegistroComponent>;
  let registroService: RegistroService;
  let tipoElectrodomesticoService: TipoElectrodomesticoService;
  let tiposElectrodomestico: TipoElectrodomestico[] = [new TipoElectrodomestico(1,'ccc','licuadora'), new TipoElectrodomestico(2,'ccc','licuadora')]

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearRegistroComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [RegistroService, HttpService],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearRegistroComponent);
    component = fixture.componentInstance;
    registroService = TestBed.inject(RegistroService);
    tipoElectrodomesticoService = TestBed.inject(TipoElectrodomesticoService);
    spyOn(registroService, 'guardar').and.returnValue(
      of(true)
    );
    spyOn(tipoElectrodomesticoService, 'listarElectrodomestico').and.returnValue(
      of(tiposElectrodomestico)
    )
    fixture.detectChanges();
  });

  it('formulario es invalido cuando esta vacio', () => {
    expect(component.registroForm.valid).toBeFalsy();
  });

  it('Registrando un electrodomestico', () => {
    expect(component.registroForm.valid).toBeFalsy();
    component.registroForm.controls.nombreCliente.setValue('sebastian');
    component.registroForm.controls.cedulaCliente.setValue('103696023');
    component.registroForm.controls.fechaIngreso.setValue(new Date());
    component.registroForm.controls.tipoElectrodomestico.setValue(new TipoElectrodomestico(1,"ccc","licuadora"));
    component.registroForm.controls.telefono.setValue('156546');

    component.crearRegistro();

    expect(component.registroForm.get('nombreCliente').value).toEqual('sebastian');
  })
});
