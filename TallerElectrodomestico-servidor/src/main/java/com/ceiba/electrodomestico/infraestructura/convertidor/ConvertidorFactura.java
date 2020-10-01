package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.dto.FacturaDto;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadFactura;
import org.modelmapper.ModelMapper;

import java.util.List;

public final class ConvertidorFactura {

    private ConvertidorFactura(){}

    public static List<FacturaDto> convertirListaFacturaEntidadADto(List<EntidadFactura> listaEntidadFactura, List<FacturaDto> listaFacturaDto){
        ModelMapper modelMapper = new ModelMapper();
        listaEntidadFactura.forEach(temporal -> {
            FacturaDto facturaDto = modelMapper.map(temporal, FacturaDto.class);
            facturaDto.setRegistroDto(ConvertidorRegistro.convertirDeEntidadAModelo(temporal.getEntidadRegistro()));
            listaFacturaDto.add(facturaDto);
        });
        return listaFacturaDto;
    }
}
