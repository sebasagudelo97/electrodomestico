import { Component, OnInit } from '@angular/core';
import { Factura } from '../../shared/model/Factura';
import { FacturaService } from '../../shared/service/factura.service';

@Component({
  selector: 'app-listar-factura',
  templateUrl: './listar-factura.component.html',
  styleUrls: ['./listar-factura.component.sass']
})
export class ListarFacturaComponent implements OnInit {

  factura: Factura[];

  constructor(private facturaService: FacturaService) { }

  ngOnInit(): void {
    this.listar();
  }

  public listar(){
    this.facturaService.listarTodo()
    .subscribe(
      facturas => this.factura = facturas
    )
  }

}
