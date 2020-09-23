package com.ceiba.electrodomestico.aplicacion.fabrica;

import com.ceiba.electrodomestico.aplicacion.comando.ComandoRegistro;
import com.ceiba.electrodomestico.dominio.modelo.Registro;
import org.springframework.stereotype.Component;

@Component
public class FabricaRegistro {

    public Registro crear(ComandoRegistro comandoRegistro){
        return new Registro(comandoRegistro.getId(), comandoRegistro.getNombreCliente(),comandoRegistro.getCedulaCliente(),comandoRegistro.getTipoElectrodomestico(),comandoRegistro.getFechaIngreso(),comandoRegistro.getFechaSalida(),comandoRegistro.isEstadoRegistro(),comandoRegistro.getTelefono(),comandoRegistro.getValorPagar());
    }
}
