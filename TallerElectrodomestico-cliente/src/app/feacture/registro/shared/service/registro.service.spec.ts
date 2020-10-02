import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';
import { environment } from 'src/environments/environment';
import { Registro } from '../model/registro';

import { RegistroService } from './registro.service';

describe('RegistroService', () => {
  let service: RegistroService;
  let httpMock: HttpTestingController;
  const apiEndpointRegistro = `${environment.endpoint}registro`;
  const apiEndPointRegistroEntrega = `${environment.endpoint}registro/entrega`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [RegistroService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(RegistroService);
  });

  it('should be created', () => {
    const registroService: RegistroService = TestBed.inject(RegistroService);
    expect(registroService).toBeTruthy();
  });

  it('Debera crear un registro', () => {
    const dummyRegistro = new Registro(1,'sebastian','1155',null,new Date(),new Date(),false,false,'65665',0);
    service.guardar(dummyRegistro).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointRegistro);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  })

  it('Debera de listar los registros que no estan para entrega', () => {
    const dummyRegistros = [
      new Registro(1,'sebastian','1155',new TipoElectrodomestico(1,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0),
      new Registro(2,'sebastian','1155',new TipoElectrodomestico(2,"ccc","licuadora"),new Date(),new Date(),false,false,'65665',0)
    ];
    service.listarTodo().subscribe(registros => {
      expect(registros.length).toBe(2);
      expect(registros).toEqual(dummyRegistros);
    });
    const req = httpMock.expectOne(apiEndpointRegistro);
    expect(req.request.method).toBe('GET');
    req.flush(dummyRegistros);
  })

  it('Debera de listar los registros que estan listos para entrega', () => {
    const dummyRegistros = [
     new Registro(1,'sebastian','1155',null,new Date(),new Date(),false,false,'65665',0),
      new Registro(2,'sebastian','1155',null,new Date(),new Date(),false,false,'65665',0)
    ];
    service.listarTodoParaEntrega().subscribe(registros => {
      expect(registros.length).toBe(2);
      expect(registros).toEqual(dummyRegistros);
    });
    const req = httpMock.expectOne(apiEndPointRegistroEntrega);
    expect(req.request.method).toBe('GET');
    req.flush(dummyRegistros);
  })
});
