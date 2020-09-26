package com.ceiba.electrodomestico.aplicacion.manejador.registro;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.fabrica.FabricaRegistro;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioCrearRegistro;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearRegistro {

    private final ServicioCrearRegistro servicioCrearRegistro;
    private final FabricaRegistro fabricaRegistro;

    public ManejadorCrearRegistro(ServicioCrearRegistro servicioCrearRegistro, FabricaRegistro fabricaRegistro) {
        this.servicioCrearRegistro = servicioCrearRegistro;
        this.fabricaRegistro = fabricaRegistro;
    }

    public void ejecutar(ComandoRegistro comandoRegistro){
        Registro registro = this.fabricaRegistro.crear(comandoRegistro);
        this.servicioCrearRegistro.ejecutar(registro);
    }
}
