import { TipoElectrodomestico } from 'src/app/feacture/components/tipo-electrodomestico/model/TipoElectrodomestico';

export class Registro {
    id?: number;
    nombreCliente: string;
    cedulaCliente: string;
    tipoElectrodomestico: TipoElectrodomestico;
    fechaIngreso: Date;
    fechaSalida: Date;
    estadoFactura: boolean;
    estado: boolean;
    telefono: string;
    valorPagar: number;

    constructor(id: number,nombreCliente:string,cedulaCliente:string,tipoElectrodomestico:TipoElectrodomestico,fechaIngreso:Date,fechaSalida:Date,estadoFactura:boolean,estado:boolean,telefono:string,valorPagar:number){
        this.id=id;
        this.nombreCliente=nombreCliente;
        this.cedulaCliente=cedulaCliente;
        this.tipoElectrodomestico=tipoElectrodomestico;
        this.fechaIngreso=fechaIngreso;
        this.fechaSalida=fechaSalida;
        this.estadoFactura=estadoFactura;
        this.estado=estado;
        this.telefono=telefono;
        this.valorPagar=valorPagar;
    }
}