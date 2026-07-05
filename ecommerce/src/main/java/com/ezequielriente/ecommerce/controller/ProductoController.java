package com.ezequielriente.ecommerce.controller;

import com.ezequielriente.ecommerce.dto.response.ProductoResponseDTO;
import com.ezequielriente.ecommerce.mapper.ProductoMapper;
import com.ezequielriente.ecommerce.service.ProductoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService service;

    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductoResponseDTO> listar() {

        return service.listar()
                .stream()
                .map(ProductoMapper::toDTO)
                .toList();
    }
}