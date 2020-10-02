import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { FacturaService } from './factura.service';
import { environment } from 'src/environments/environment';
import { HttpService } from 'src/app/core/services/http.service';
import { Factura } from '../model/Factura';
import { HttpResponse } from '@angular/common/http';

describe('FacturaService', () => {
  let service: FacturaService;
  let httpMock: HttpTestingController;
  const apiEndpointFactura = `${environment.endpoint}factura`;

  beforeEach(() => {
    const injector = TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [FacturaService, HttpService]
    });
    httpMock = injector.inject(HttpTestingController)
    service = TestBed.inject(FacturaService);
  });

  it('should be created', () => {
    const facturaService: FacturaService = TestBed.inject(FacturaService);
    expect(facturaService).toBeTruthy();
  });

  it('Debera crear una factura', () => {
    const dummyFactura =  new Factura();
    service.crearFactura(dummyFactura).subscribe((respuesta) => {
      expect(respuesta).toEqual(true);
    });
    const req = httpMock.expectOne(apiEndpointFactura);
    expect(req.request.method).toBe('POST');
    req.event(new HttpResponse<boolean>({body: true}));
  })

  it('Debera listar las facturas', () => {
    const dummyFacturas = [
      new Factura(), new Factura()
    ];
    service.listarTodo().subscribe(facturas => {
      expect(facturas.length).toBe(2);
      expect(facturas).toEqual(dummyFacturas);
    });
    const req = httpMock.expectOne(apiEndpointFactura);
    expect(req.request.method).toBe('GET');
    req.flush(dummyFacturas);
  });
});
