import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarTodoRegistroComponent } from './listar-todo-registro.component';

describe('ListarTodoRegistroComponent', () => {
  let component: ListarTodoRegistroComponent;
  let fixture: ComponentFixture<ListarTodoRegistroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarTodoRegistroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarTodoRegistroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
