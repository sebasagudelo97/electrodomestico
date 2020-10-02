import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/core/services/http.service';
import { environment } from 'src/environments/environment';
import { Registro } from '../model/registro';

@Injectable({
  providedIn: 'root'
})
export class RegistroService {

  public registro: Registro;

  constructor(protected http: HttpService) { }

  public guardar(registro: Registro){    
    return this.http.doPost<Registro, boolean>(`${environment.endpoint}registro`, registro);
  }

  public listarTodo(){
    return this.http.doGet<Registro[]>(`${environment.endpoint}registro`,this.http.optsName('consultar productos en proceso'));
  }

  public actualizar(id:number, registro:Registro){
    return this.http.doPut<Registro, boolean>(`${environment.endpoint}registro/${id}`, registro);
  }

  public listarTodoParaEntrega(){
    return this.http.doGet<Registro[]>(`${environment.endpoint}registro/entrega`, this.http.optsName('consultar producto ya para entrega'))
  }
  
}
