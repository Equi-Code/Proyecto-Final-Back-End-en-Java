package com.ezequielriente.ecommerce.mapper;

import com.ezequielriente.ecommerce.dto.request.AccesorioRequestDTO;
import com.ezequielriente.ecommerce.dto.response.AccesorioResponseDTO;
import com.ezequielriente.ecommerce.model.Accesorio;

public class AccesorioMapper {

    public static Accesorio toEntity(AccesorioRequestDTO dto) {

        Accesorio accesorio = new Accesorio();

        accesorio.setNombre(dto.getNombre());
        accesorio.setPrecio(dto.getPrecio());
        accesorio.setStock(dto.getStock());
        accesorio.setTipo(dto.getTipo());
        accesorio.setDescripcion(dto.getDescripcion());
accesorio.setImagenUrl(dto.getImagenUrl());

        return accesorio;
    }

    public static AccesorioResponseDTO toDTO(Accesorio accesorio) {

        AccesorioResponseDTO dto = new AccesorioResponseDTO();

        dto.setId(accesorio.getId());
        dto.setNombre(accesorio.getNombre());
        dto.setPrecio(accesorio.getPrecio());
        dto.setStock(accesorio.getStock());
        dto.setTipo(accesorio.getTipo());
        dto.setCategoria(accesorio.getCategoria());
                accesorio.setDescripcion(dto.getDescripcion());
accesorio.setImagenUrl(dto.getImagenUrl());

        return dto;
    }
}
