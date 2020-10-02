import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/services/http.service';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { Registro } from '../../shared/model/registro';
import { RegistroService } from '../../shared/service/registro.service';

import { ListarSoloEntregaRegistroComponent } from './listar-solo-entrega-registro.component';

describe('ListarSoloEntregaRegistroComponent', () => {
  let component: ListarSoloEntregaRegistroComponent;
  let fixture: ComponentFixture<ListarSoloEntregaRegistroComponent>;
  let registroService: RegistroService;
  const listaRegistros: Registro[] = [new Registro(1,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0),
  new Registro(1,'sebastian','1155',new TipoElectrodomestico(1,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0)];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarSoloEntregaRegistroComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule
      ],
      providers: [RegistroService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarSoloEntregaRegistroComponent);
    component = fixture.componentInstance;
    registroService = TestBed.inject(RegistroService);
    spyOn(registroService, 'listarTodoParaEntrega').and.returnValue(
      of(listaRegistros)
    );
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
    component.registro.subscribe(resultado => {
      expect(resultado.length).toBe(2);
    })
  })

});
