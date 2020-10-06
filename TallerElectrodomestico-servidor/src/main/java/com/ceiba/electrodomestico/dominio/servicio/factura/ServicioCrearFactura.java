package com.ceiba.electrodomestico.dominio.servicio.factura;

import com.ceiba.electrodomestico.dominio.excepcion.ExcepcionRegistroNulo;
import com.ceiba.electrodomestico.dominio.modelo.Factura;
import com.ceiba.electrodomestico.dominio.puerto.repositorio.RepositorioFactura;

public class ServicioCrearFactura {

    private static final String REGISTRO_NULO = "El registro no puede ser nulo";

    private final RepositorioFactura repositorioFactura;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura) {
        this.repositorioFactura = repositorioFactura;
    }

    public static void validarRegistroEnFacturaNoNulo(Factura factura){
        if(factura.getRegistro() == null){
            throw new ExcepcionRegistroNulo(REGISTRO_NULO);
        }
    }

    public void ejecutar(Factura factura){
        validarRegistroEnFacturaNoNulo(factura);
        factura.calcularValorAPagar();
        repositorioFactura.guardar(factura);
    }
}
