import { Registro } from 'src/app/feacture/registro/shared/model/registro';

export class Factura{
    id?: number;
    fechaActual: Date;
    valorAdicional:number;
    registroDto: Registro;

    constructor(id:number,fechaActual:Date,valorAdicional:number,registroDto:Registro){
        this.id=id;
        this.fechaActual=fechaActual;
        this.valorAdicional=valorAdicional;
        this.registroDto=registroDto;
    }
}