import { DatePipe } from '@angular/common';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'formatoFecha'
})
export class FechaPipe implements PipeTransform {

  constructor(private datePipe: DatePipe){}

  transform(value: string, format: string = 'dd-MM-yyyy') {
    let date = new Date(parseInt(value.substr(6)));
    return this.datePipe.transform(date,format)
  }

}
