package com.ceiba.electrodomestico.aplicacion.manejador;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.aplicacion.fabrica.FabricaRegistro;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import com.ceiba.electrodomestico.dominio.servicio.registro.ServicioSalidaAEntregaElectrodomestico;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarRegistroParaEntrega {

    private static final boolean CAMBIO_DE_ESTADO = true;
    private final ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico;
    private final FabricaRegistro fabricaRegistro;

    public ManejadorActualizarRegistroParaEntrega(ServicioSalidaAEntregaElectrodomestico servicioSalidaAEntregaElectrodomestico, FabricaRegistro fabricaRegistro) {
        this.servicioSalidaAEntregaElectrodomestico = servicioSalidaAEntregaElectrodomestico;
        this.fabricaRegistro = fabricaRegistro;
    }

    public void ejecutar(ComandoRegistro comandoRegistro, long id){
        comandoRegistro.setEstadoRegistro(CAMBIO_DE_ESTADO);
        comandoRegistro.setId(id);
        Registro registro = this.fabricaRegistro.crear(comandoRegistro);
        this.servicioSalidaAEntregaElectrodomestico.actualizarYGuardarRegistro(registro);
    }
}
