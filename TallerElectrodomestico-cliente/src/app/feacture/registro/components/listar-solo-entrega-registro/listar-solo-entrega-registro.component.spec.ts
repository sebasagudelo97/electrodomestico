import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarSoloEntregaRegistroComponent } from './listar-solo-entrega-registro.component';

describe('ListarSoloEntregaRegistroComponent', () => {
  let component: ListarSoloEntregaRegistroComponent;
  let fixture: ComponentFixture<ListarSoloEntregaRegistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarSoloEntregaRegistroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarSoloEntregaRegistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
