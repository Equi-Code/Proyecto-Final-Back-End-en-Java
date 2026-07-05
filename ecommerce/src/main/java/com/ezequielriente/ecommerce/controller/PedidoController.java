package com.ezequielriente.ecommerce.controller;

import com.ezequielriente.ecommerce.dto.request.PedidoRequestDTO;
import com.ezequielriente.ecommerce.dto.response.PedidoResponseDTO;
import com.ezequielriente.ecommerce.mapper.PedidoMapper;
import com.ezequielriente.ecommerce.model.Pedido;
import com.ezequielriente.ecommerce.response.ApiResponseDTO;
import com.ezequielriente.ecommerce.service.PedidoService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PedidoResponseDTO> listar() {

        return service.listar()
                .stream()
                .map(PedidoMapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscar(@PathVariable Integer id) {

        Pedido pedido = service.buscarPorId(id);

        return ResponseEntity.ok(
                PedidoMapper.toDTO(pedido));
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> guardar(
            @Valid @RequestBody PedidoRequestDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.guardar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> actualizar(
            @PathVariable Integer id,
            @RequestBody Pedido pedido) {

        return ResponseEntity.ok(
                service.actualizar(id, pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> eliminar(
            @PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponseDTO(
                        true,
                        "Pedido eliminado correctamente"));
    }
}