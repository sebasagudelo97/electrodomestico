package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionFechaInvalida;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionFechaSalidaNula;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicioSalidaAEntregaElectrodomestico {

    private final RepositorioRegistro repositorioRegistro;
    private static final String VALOR_INVALIDO = "El valor no puede ser menor o igual a cero";
    private static final String FECHA_SALIDA_NULA = "La fecha de salida no puede ser nula";
    private static final String FECHA_INVALIDA = "La fecha de salida no puede ser menor a la de entrada";

    public ServicioSalidaAEntregaElectrodomestico(RepositorioRegistro repositorioRegistro) {
        this.repositorioRegistro = repositorioRegistro;
    }

    public  void validarValor(double valor){
        if (valor <= 0){
            throw new ExcepcionValorInvalido(VALOR_INVALIDO);
        }
    }

    public  void validarFechaSalida(LocalDate fecha){
        if (fecha == null){
            throw new ExcepcionFechaSalidaNula(FECHA_SALIDA_NULA);
        }
    }

    public void actualizarYGuardarRegistro(Registro registro){
        this.validarFechaSalida(registro.getFechaSalida());
        if(registro.getFechaSalida().isAfter(registro.getFechaIngreso())){
            this.validarValor(registro.getValorPagar());
            this.repositorioRegistro.guardar(registro);
        }else {
            throw new ExcepcionFechaInvalida(FECHA_INVALIDA);
        }
    }
}
