import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/core/services/http.service';
import { environment } from 'src/environments/environment';
import { Factura } from '../model/Factura';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {

  constructor(private http: HttpService) { }

  public crearFactura(factura: Factura){
    return this.http.doPost<Factura, boolean>(`${environment.endpoint}factura`, factura);
  }

  public listarTodo(){
    return this.http.doGet<Factura[]>(`${environment.endpoint}factura`, this.http.optsName('Listar las facturas'))
  }
}
