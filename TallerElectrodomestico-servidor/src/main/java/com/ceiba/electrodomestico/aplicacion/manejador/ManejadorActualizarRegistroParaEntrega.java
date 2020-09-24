package com.ceiba.electrodomestico.aplicacion.manejador;

import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioSalidaAEntregaElectrodomestico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRegistroParaEntrega {

    private final ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico;

    public ManejadorActualizarRegistroParaEntrega(ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico) {
        this.servicioSalidaAEntregaElectrodomestico = servicioSalidaAEntregaElectrodomestico;
    }

    public void ejecutar(long id){
        this.servicioSalidaAEntregaElectrodomestico.actualizarYGuardarRegistro(id);
    }
}
