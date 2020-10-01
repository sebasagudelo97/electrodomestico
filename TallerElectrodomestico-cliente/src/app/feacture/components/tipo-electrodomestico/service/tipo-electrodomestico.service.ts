import { Injectable } from '@angular/core';
import { HttpService } from 'src/app/core/services/http.service';
import { environment } from 'src/environments/environment';
import { TipoElectrodomestico } from '../model/TipoElectrodomestico';

@Injectable({
  providedIn: 'root'
})
export class TipoElectrodomesticoService {

  constructor(protected http: HttpService) { }

  public listarElectrodomestico(){
    return this.http.doGet<TipoElectrodomestico[]>(`${environment.endpoint}tipo-electrodomestico`)
  }
}
