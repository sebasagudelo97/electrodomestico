import { TestBed } from '@angular/core/testing';

import { TipoElectrodomesticoService } from './tipo-electrodomestico.service';

describe('TipoElectrodomesticoService', () => {
  let service: TipoElectrodomesticoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoElectrodomesticoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
