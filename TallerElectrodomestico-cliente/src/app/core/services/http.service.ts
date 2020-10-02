import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams  } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

export interface Options {
  headers?: HttpHeaders;
  params?: HttpParams;
}
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(protected http: HttpClient) { }

  public createDefaultOptions(): Options {
    return {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
  }

  public optsName(name: string): Options {
    return this.setHeader('xhr-name', name);
  }

  private setHeader(name: string, value: string) {
    const newopts = this.createDefaultOptions();
    newopts.headers = newopts.headers.set(name, value);
    return newopts;
  }

  private createOptions(opts: Options): Options {
    const defaultOpts: Options = this.createDefaultOptions();

    if (opts) {
      opts = {
        params: opts.params || defaultOpts.params,
        headers: opts.headers || defaultOpts.headers
      };

      if (!opts.headers.get('Content-Type')) {
        opts.headers = opts.headers.set('Content-Type', defaultOpts.headers.get('Content-Type'));
      }
    }

    return opts || defaultOpts;
  }

  public doGet<T>(serviceUrl: string, opts?: Options): Observable<T> {
    const ropts = this.createOptions(opts);
    return this.http.get<T>(serviceUrl, ropts);
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
