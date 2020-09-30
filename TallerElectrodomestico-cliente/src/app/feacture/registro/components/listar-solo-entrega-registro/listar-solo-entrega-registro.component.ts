import { Component, OnInit } from '@angular/core';
import { Registro } from '../../shared/model/registro';
import { RegistroService } from '../../shared/service/registro.service';

@Component({
  selector: 'app-listar-solo-entrega-registro',
  templateUrl: './listar-solo-entrega-registro.component.html',
  styleUrls: ['./listar-solo-entrega-registro.component.sass']
})
export class ListarSoloEntregaRegistroComponent implements OnInit {

  registro:Registro[];

  constructor(protected servicioRegistro: RegistroService) { }

  ngOnInit(): void {
    this.listarEntrega();
  }

  public listarEntrega(): void{
    this.servicioRegistro.listarTodoParaEntrega()
    .subscribe(
      registros => this.registro = registros
    );
  }

}
