import { Injectable } from '@angular/core';
import { HttpClient  } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(protected http: HttpClient) { }

  public doGet<T>(serviceUrl: string) {
    return this.http.get(serviceUrl).pipe(
      map(response => response as T)
    );
  }

  public doPost<T, R>(serviceUrl: string, body: T) {
    return this.http.post(serviceUrl, body).pipe(
      map(respose => respose as R)
    );
  }

  public doPut<T, R>(serviceUrl: string, body: T){
    return this.http.put(serviceUrl, body).pipe(
      map(respose => respose as R)
    );
  }


}
