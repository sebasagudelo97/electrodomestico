import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/services/http.service';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { Registro } from 'src/app/feacture/registro/shared/model/registro';
import { Factura } from '../../shared/model/Factura';
import { FacturaService } from '../../shared/service/factura.service';

import { ListarFacturaComponent } from './listar-factura.component';

describe('ListarFacturaComponent', () => {
  let component: ListarFacturaComponent;
  let fixture: ComponentFixture<ListarFacturaComponent>;
  let facturaService: FacturaService;
  let listaFactura: Factura[] = [
    new Factura(1,new Date(), 500, new Registro(1,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0)),
    new Factura(2,new Date(), 500, new Registro(1,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0))
  ]

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarFacturaComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [FacturaService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarFacturaComponent);
    component = fixture.componentInstance;
    facturaService = TestBed.inject(FacturaService);
    spyOn(facturaService, 'listarTodo').and.returnValue(
      of(listaFactura)
    )
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.factura.subscribe(resultado => {
      expect(resultado.length).toBe(2);
    })
  })

});
