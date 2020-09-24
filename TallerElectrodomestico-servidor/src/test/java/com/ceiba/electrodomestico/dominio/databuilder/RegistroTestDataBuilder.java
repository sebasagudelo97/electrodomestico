package com.ceiba.electrodomestico.dominio.databuilder;

import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;

import java.time.LocalDate;

public class RegistroTestDataBuilder {

    private static final long ID = 1l;
    private static final String NOMBRE_CLIENTE= "sebastian";
    private static final String CEDULA_CLIENTE= "1036960221";
    private static final TipoElectrodomestico TIPO_ELECTRODOMESTICO= new TipoElectrodomesticoTestDataBuilder().build();
    private static final LocalDate FECHA_INGRESO = LocalDate.now();
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

    public RegistroTestDataBuilder(){
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

    public RegistroTestDataBuilder conId(long id){
        this.id = id;
        return this;
    }

    public RegistroTestDataBuilder conNombreCliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
        return this;
    }

    public RegistroTestDataBuilder conCedulaCliente(String cedulaCliente){
        this.cedulaCliente = cedulaCliente;
        return this;
    }

    public RegistroTestDataBuilder conTipoElectrodomestico(TipoElectrodomestico tipoElectrodomestico){
        this.tipoElectrodomestico = tipoElectrodomestico;
        return this;
    }

    public RegistroTestDataBuilder conFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public RegistroTestDataBuilder conFechaSalida(LocalDate fechaSalida){
        this.fechaSalida = fechaSalida;
        return this;
    }

    public RegistroTestDataBuilder conEstado(boolean estado){
        this.estado = estado;
        return this;
    }

    public RegistroTestDataBuilder conTelefono(String telefono){
        this.telefono = telefono;
        return this;
    }

    public RegistroTestDataBuilder conValorPagar(double valorPagar){
        this.valorPagar = valorPagar;
        return this;
    }

    public Registro build(){
        return new Registro(this.id,this.nombreCliente,this.cedulaCliente,this.tipoElectrodomestico,this.fechaIngreso,this.fechaSalida,this.estado,this.telefono,this.valorPagar
                );
    }
}
