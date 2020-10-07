import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Factura } from '../../shared/model/Factura';
import { FacturaService } from '../../shared/service/factura.service';

@Component({
  selector: 'app-listar-factura',
  templateUrl: './listar-factura.component.html',
  styleUrls: ['./listar-factura.component.sass']
})
export class ListarFacturaComponent implements OnInit {

  factura: Observable<Factura[]>;

  constructor(private facturaService: FacturaService) { }

  ngOnInit(): void {
    this.factura = this.facturaService.listarTodo();
  } 

}
