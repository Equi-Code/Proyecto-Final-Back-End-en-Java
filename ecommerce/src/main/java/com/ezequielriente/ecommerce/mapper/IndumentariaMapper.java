package com.ezequielriente.ecommerce.mapper;

import com.ezequielriente.ecommerce.dto.request.IndumentariaRequestDTO;
import com.ezequielriente.ecommerce.dto.response.IndumentariaResponseDTO;
import com.ezequielriente.ecommerce.model.IndumentariaDeportiva;

public class IndumentariaMapper {

    public static IndumentariaDeportiva toEntity(IndumentariaRequestDTO dto) {

        IndumentariaDeportiva indumentaria = new IndumentariaDeportiva();

        indumentaria.setNombre(dto.getNombre());
        indumentaria.setPrecio(dto.getPrecio());
        indumentaria.setStock(dto.getStock());
        indumentaria.setMarca(dto.getMarca());
        indumentaria.setTalle(dto.getTalle());

        return indumentaria;
    }

    public static IndumentariaResponseDTO toDTO(IndumentariaDeportiva indumentaria) {

        IndumentariaResponseDTO dto = new IndumentariaResponseDTO();

        dto.setId(indumentaria.getId());
        dto.setNombre(indumentaria.getNombre());
        dto.setPrecio(indumentaria.getPrecio());
        dto.setStock(indumentaria.getStock());
        dto.setMarca(indumentaria.getMarca());
        dto.setTalle(indumentaria.getTalle());
        dto.setCategoria(indumentaria.getCategoria());

        return dto;
    }
}