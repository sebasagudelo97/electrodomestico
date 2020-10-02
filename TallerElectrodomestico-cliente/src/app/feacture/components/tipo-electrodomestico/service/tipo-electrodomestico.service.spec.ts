import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { HttpService } from 'src/app/core/services/http.service';
import { environment } from 'src/environments/environment';
import { TipoElectrodomestico } from '../model/TipoElectrodomestico';

import { TipoElectrodomesticoService } from './tipo-electrodomestico.service';

describe('TipoElectrodomesticoService', () => {
  let service: TipoElectrodomesticoService;
  let httpMock: HttpTestingController;
  const apiEndpointTipoElectrodomestico =  `${environment.endpoint}tipo-electrodomestico`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [TipoElectrodomesticoService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController);
    service = TestBed.inject(TipoElectrodomesticoService);
  });

  it('should be created', () => {
    const tipoElectrodomesticoService: TipoElectrodomesticoService = TestBed.inject(TipoElectrodomesticoService);
    expect(tipoElectrodomesticoService).toBeTruthy();
  });

  it('Debera listar los tipos de electrodomestico', () => {
    const dummyTipoElectrodomesticos = [
      new TipoElectrodomestico(),
      new TipoElectrodomestico()
    ];
    service.listarElectrodomestico().subscribe(tipoElectrodomesticos => {
      expect(tipoElectrodomesticos.length).toBe(2);
      expect(tipoElectrodomesticos).toEqual(dummyTipoElectrodomesticos);
    });
    const req = httpMock.expectOne(apiEndpointTipoElectrodomestico);
    expect(req.request.method).toBe('GET');
    req.flush(dummyTipoElectrodomesticos);
  })
});
