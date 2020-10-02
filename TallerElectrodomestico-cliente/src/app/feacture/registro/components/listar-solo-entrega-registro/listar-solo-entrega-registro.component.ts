import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalConfig } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs';
import { Registro } from '../../shared/model/registro';
import { RegistroService } from '../../shared/service/registro.service';

@Component({
  selector: 'app-listar-solo-entrega-registro',
  templateUrl: './listar-solo-entrega-registro.component.html',
  styleUrls: ['./listar-solo-entrega-registro.component.sass']
})
export class ListarSoloEntregaRegistroComponent implements OnInit {

  public registro: Observable<Registro[]>;

  constructor(protected servicioRegistro: RegistroService,config: NgbModalConfig, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.listarEntrega();
  }

  public listarEntrega(): void{  
      this.registro = this.servicioRegistro.listarTodoParaEntrega();    
  }

  public open(content, registro: Registro): void {
    this.modalService.open(content);
    this.enviarRegistroPorServicio(registro);    
  }

  public enviarRegistroPorServicio (registro: Registro):void{
    this.servicioRegistro.registro = registro;
  }
}
