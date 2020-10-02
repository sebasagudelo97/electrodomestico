import { HttpResponse } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from 'src/app/core/services/http.service';
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
    const dummyRegistro = new Registro();
    service.guardar(dummyRegistro).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointRegistro);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  })

  it('Debera de listar los registros que no estan para entrega', () => {
    const dummyRegistros = [
      new Registro(),
      new Registro()
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
      new Registro(),
      new Registro()
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
