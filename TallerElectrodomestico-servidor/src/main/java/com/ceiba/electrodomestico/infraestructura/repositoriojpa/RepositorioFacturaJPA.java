package com.ceiba.electrodomestico.infraestructura.repositoriojpa;

import com.ceiba.electrodomestico.infraestructura.entidad.EntidadFactura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;


public interface RepositorioFacturaJPA extends JpaRepository<EntidadFactura, Serializable> {

}
