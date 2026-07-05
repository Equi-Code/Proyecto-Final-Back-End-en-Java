package com.ezequielriente.ecommerce.mapper;

import com.ezequielriente.ecommerce.dto.response.ProductoResponseDTO;
import com.ezequielriente.ecommerce.model.Producto;

public class ProductoMapper {

    public static ProductoResponseDTO toDTO(Producto producto){

        ProductoResponseDTO dto = new ProductoResponseDTO();

        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setCategoria(producto.getCategoria());

        return dto;
    }

}