package com.ezequielriente.ecommerce.controller;

import com.ezequielriente.ecommerce.dto.request.PedidoRequestDTO;
import com.ezequielriente.ecommerce.dto.response.PedidoResponseDTO;
import com.ezequielriente.ecommerce.mapper.PedidoMapper;
import com.ezequielriente.ecommerce.model.Pedido;
import com.ezequielriente.ecommerce.response.ApiResponseDTO;
import com.ezequielriente.ecommerce.service.PedidoService;
import com.ezequielriente.ecommerce.dto.request.EstadoPedidoRequestDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

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

        @Operation(summary = "Listar pedidos")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
        })

        @GetMapping
        public List<PedidoResponseDTO> listar() {

                return service.listar()
                                .stream()
                                .map(PedidoMapper::toDTO)
                                .toList();
        }

        @Operation(summary = "Buscar pedido por ID")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
                        @ApiResponse(responseCode = "404", description = "Pedido no encontrado")
        })

        @GetMapping("/{id}")
        public ResponseEntity<PedidoResponseDTO> buscar(@PathVariable Integer id) {

                Pedido pedido = service.buscarPorId(id);

                return ResponseEntity.ok(
                                PedidoMapper.toDTO(pedido));
        }

        @Operation(summary = "Crear pedido")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", description = "Pedido creado correctamente")
        })
        @PostMapping
        public ResponseEntity<PedidoResponseDTO> guardar(
                        @Valid @RequestBody PedidoRequestDTO dto) {

                PedidoResponseDTO pedido = service.guardar(dto);

                return ResponseEntity
                                .status(HttpStatus.CREATED)
                                .body(pedido);
        }

        @Operation(summary = "Eliminar pedido")
        @DeleteMapping("/{id}")
        public ResponseEntity<ApiResponseDTO> eliminar(
                        @PathVariable Integer id) {

                service.eliminar(id);

                return ResponseEntity.ok(
                                new ApiResponseDTO(
                                                true,
                                                "Pedido eliminado correctamente"));
        }

        @PatchMapping("/{id}/estado")
        public PedidoResponseDTO cambiarEstado(
                        @PathVariable Integer id,
                        @RequestBody EstadoPedidoRequestDTO dto) {

                return service.cambiarEstado(id, dto.getEstado());

        }

}