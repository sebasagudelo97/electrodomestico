import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/services/http.service';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { Registro } from 'src/app/feacture/registro/shared/model/registro';
import { RegistroService } from 'src/app/feacture/registro/shared/service/registro.service';
import { FacturaService } from '../../shared/service/factura.service';

import { CrearFacturaComponent } from './crear-factura.component';

describe('CrearFacturaComponent', () => {
  let component: CrearFacturaComponent;
  let fixture: ComponentFixture<CrearFacturaComponent>;
  let facturaService: FacturaService;
  let registroService: RegistroService;
  const registroNuevo = new Registro(1,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0);

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearFacturaComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [FacturaService, HttpService],
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearFacturaComponent);
    component = fixture.componentInstance;
    facturaService = TestBed.inject(FacturaService);
    registroService = TestBed.inject(RegistroService);
    registroService.registro = registroNuevo;
    spyOn(facturaService, 'crearFactura').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
  });

  it('Registrar una factura', () => {
    component.registroForm.controls.fechaActual.setValue(new Date());
    component.registroForm.controls.registro.setValue(new Registro(1,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0))
    expect(component.registroForm.valid).toBeTruthy();

    component.crearFactura();
  })

  
});
