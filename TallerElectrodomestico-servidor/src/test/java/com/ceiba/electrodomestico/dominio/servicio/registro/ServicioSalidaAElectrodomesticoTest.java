package com.ceiba.electrodomestico.dominio.servicio.registro;

import com.ceiba.electrodomestico.dominio.databuilder.modelo.RegistroTestDataBuilder;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionFechaInvalida;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionFechaSalidaNula;
import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioRegistro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;

public class ServicioSalidaAElectrodomesticoTest {

    private static final double VALOR = 0;
    private static final String VALOR_INVALIDO = "El valor no puede ser menor o igual a cero";
    private static final String FECHA_SALIDA_NULA = "La fecha de salida no puede ser nula";
    private static final LocalDate FECHA_SALIDA = LocalDate.of(2020,9, 20);
    private static final String FECHA_INVALIDA = "La fecha de salida no puede ser menor a la de entrada";

    private RepositorioRegistro repositorioRegistro;
    private ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico;

    @BeforeEach
    public void init(){
        repositorioRegistro = Mockito.mock(RepositorioRegistro.class);
        servicioSalidaAEntregaElectrodomestico = new ServicioSalidaAEntregaElectrodomestico(repositorioRegistro);

    }

    @Test
    public void validarValorMenorOIgualACeroTest(){
        double valor = VALOR;
        try {
            this.servicioSalidaAEntregaElectrodomestico.validarValor(valor);
        }catch (ExcepcionValorInvalido e){
            Assertions.assertEquals(VALOR_INVALIDO, e.getMessage());
        }
    }

    @Test
    public void validarFechaSalidaNulaTest(){
        try {
            this.servicioSalidaAEntregaElectrodomestico.validarFechaSalida(null);
        }catch (ExcepcionFechaSalidaNula e){
            Assertions.assertEquals(FECHA_SALIDA_NULA, e.getMessage());
        }
    }

    @Test
    public void actualizarYGuardarRegistroConFechaDeSalidaMenorALaFechaDeEntradaTest(){
        Registro registro = new RegistroTestDataBuilder().conFechaSalida(FECHA_SALIDA).build();

        try {
            this.servicioSalidaAEntregaElectrodomestico.actualizarYGuardarRegistro(registro);
        }catch (ExcepcionFechaInvalida e){
            Assertions.assertEquals(FECHA_INVALIDA, e.getMessage());
        }
    }
}
