import { Component, OnInit, Output } from '@angular/core';
import { Registro } from '../../shared/model/registro';
import { RegistroService } from '../../shared/service/registro.service';
import { NgbModalConfig, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import {  FormGroup } from '@angular/forms';

@Component({
  selector: 'app-listar-todo-registro',
  templateUrl: './listar-todo-registro.component.html',
  styleUrls: ['./listar-todo-registro.component.sass']
})
export class ListarTodoRegistroComponent implements OnInit {

  public registro: Registro[];
   registroTemporal: Registro; 
  registroForm: FormGroup;
  constructor(private listarTodoService: RegistroService,config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.listarTodo();
  }

  public listarTodo(): void{
    this.listarTodoService.listarTodo()    
    .subscribe(
      registros => this.registro = registros
    )
  }

  public open(content, registro: Registro): void {
    this.enviarRegistroPorServicio(registro);
    this.modalService.open(content);    
  }

  public enviarRegistroPorServicio (registro: Registro):void{
    this.registroTemporal = registro;
    this.listarTodoService.registro = this.registroTemporal;
  }
}
