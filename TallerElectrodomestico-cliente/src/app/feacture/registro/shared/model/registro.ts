import { TipoElectrodomestico } from 'src/app/shared/model/TipoElectrodomestico';

export class Registro {
    id?: number;
    nombreCliente: string;
    cedulaCliente: string;
    tipoElectrodomestico: TipoElectrodomestico;
    fechaIngreso: Date;
    fechaSalida: Date;
    estado: boolean;
    telefono: string;
    valorPagar: number;
}