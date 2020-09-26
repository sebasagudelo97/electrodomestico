package com.ceiba.electrodomestico.infraestructura.repositoriojpa;

import com.ceiba.electrodomestico.infraestructura.entidad.EntidadFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface RepositorioFacturaJPA extends JpaRepository<EntidadFactura, Serializable> {

}
