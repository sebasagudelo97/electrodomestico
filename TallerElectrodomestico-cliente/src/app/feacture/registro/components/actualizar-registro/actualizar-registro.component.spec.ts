import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { of } from 'rxjs';
import { HttpService } from 'src/app/core/services/http.service';
import { RegistroService } from '../../shared/service/registro.service';

import { ActualizarRegistroComponent } from './actualizar-registro.component';

describe('ActualizarRegistroComponent', () => {
  let component: ActualizarRegistroComponent;
  let fixture: ComponentFixture<ActualizarRegistroComponent>;
  let registroService: RegistroService;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ActualizarRegistroComponent ],
      imports: [
        CommonModule,
        HttpClientModule,
        RouterTestingModule,
        ReactiveFormsModule,
        FormsModule
      ],
      providers: [RegistroService, HttpService]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualizarRegistroComponent);
    component = fixture.componentInstance;
    registroService = TestBed.inject(RegistroService);
    spyOn(registroService, 'actualizar').and.returnValue(
      of(true)
    );
    fixture.detectChanges();
  });
});
