package com.ceiba.electrodomestico.dominio.databuilder.comando;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.dominio.databuilder.modelo.TipoElectrodomesticoTestDataBuilder;
import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;

import java.time.LocalDate;

public class ComandoRegistroTestDataBuilder {

    private static final long ID = 1l;
    private static final String NOMBRE_CLIENTE= "sebastian";
    private static final String CEDULA_CLIENTE= "1036960221";
    private static final TipoElectrodomestico TIPO_ELECTRODOMESTICO= new TipoElectrodomesticoTestDataBuilder().build();
    private static final LocalDate FECHA_INGRESO = LocalDate.of(2020,9,26);
    private static final LocalDate FECHA_SALIDA = null;
    private static final boolean ESTADO = false;
    private static final String TELEFONO = "3144568565";
    private static final double VALOR_PAGAR = 0;

    private long id;
    private String nombreCliente;
    private String cedulaCliente;
    private TipoElectrodomestico tipoElectrodomestico;
    private LocalDate fechaIngreso;
    private LocalDate fechaSalida;
    private boolean estado;
    private String telefono;
    private double valorPagar;

    public ComandoRegistroTestDataBuilder(){
        this.id = ID;
        this.nombreCliente = NOMBRE_CLIENTE;
        this.cedulaCliente = CEDULA_CLIENTE;
        this.tipoElectrodomestico = TIPO_ELECTRODOMESTICO;
        this.fechaIngreso = FECHA_INGRESO;
        this.fechaSalida = FECHA_SALIDA;
        this.estado = ESTADO;
        this.telefono = TELEFONO;
        this.valorPagar = VALOR_PAGAR;
    }

    public ComandoRegistro build(){
        return new ComandoRegistro(this.id,this.nombreCliente, this.cedulaCliente, this.tipoElectrodomestico,this.fechaIngreso,this.fechaSalida,this.estado,this.telefono,this.valorPagar);
    }
}
