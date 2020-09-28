package com.ceiba.electrodomestico.infraestructura.convertidor;

import com.ceiba.electrodomestico.dominio.dto.TipoElectrodomesticoDto;
import com.ceiba.electrodomestico.dominio.modelo.TipoElectrodomestico;
import com.ceiba.electrodomestico.infraestructura.entidad.EntidadTipoElectrodomestico;
import org.modelmapper.ModelMapper;

import java.util.List;

public final class ConvertidorTipoElectrodomestico {

    private ConvertidorTipoElectrodomestico() { }

    public static TipoElectrodomestico convertirDeEntidadAModelo(EntidadTipoElectrodomestico entidadTipoElectrodomestico){
        return new TipoElectrodomestico(entidadTipoElectrodomestico.getId(),entidadTipoElectrodomestico.getMarca(),entidadTipoElectrodomestico.getDescripcion());
    }

    public static List<TipoElectrodomesticoDto> convertirListaTipoElectrodomesticoEntidadADto(List<EntidadTipoElectrodomestico> entidadTipoElectrodomesticos, List<TipoElectrodomesticoDto> tipoElectrodomesticoDtos){
        ModelMapper modelMapper = new ModelMapper();
        entidadTipoElectrodomesticos.forEach(temporal -> {
            TipoElectrodomesticoDto tipoElectrodomesticoDto = modelMapper.map(temporal, TipoElectrodomesticoDto.class);
            tipoElectrodomesticoDtos.add(tipoElectrodomesticoDto);
        });
        return  tipoElectrodomesticoDtos;
    }
}
