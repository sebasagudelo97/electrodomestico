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
}