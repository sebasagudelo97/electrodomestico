import { Registro } from 'src/app/feacture/registro/shared/model/registro';

export class Factura{
    id?: number;
    fechaActual: Date;
    valorAdicional:number;
    registroDto: Registro;
}