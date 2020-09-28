package com.ceiba.electrodomestico.dominio.servicio.factura;

import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioFactura;


public class ServicioCrearFactura {

    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public void ejecutar(Factura factura){
        factura.calcularValorAPagar();
        repositorioFactura.guardar(factura);
    }
}
