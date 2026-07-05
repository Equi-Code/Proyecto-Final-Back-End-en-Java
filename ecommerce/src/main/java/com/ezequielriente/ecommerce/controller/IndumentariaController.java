package com.ezequielriente.ecommerce.controller;

import com.ezequielriente.ecommerce.service.IndumentariaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.ezequielriente.ecommerce.dto.request.IndumentariaRequestDTO;
import com.ezequielriente.ecommerce.dto.response.IndumentariaResponseDTO;
import com.ezequielriente.ecommerce.mapper.IndumentariaMapper;
import com.ezequielriente.ecommerce.response.ApiResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/indumentaria")
public class IndumentariaController {

    private final IndumentariaService service;

    public IndumentariaController(IndumentariaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar indumentaria", description = "Obtiene el listado completo de indumentaria registrada.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })

    // GET - Listar todos
@GetMapping
public Page<IndumentariaResponseDTO> listar(Pageable pageable) {

    return service.listar(pageable)
            .map(IndumentariaMapper::toDTO);
}
    // GET - Buscar por ID
    @Operation(summary = "Buscar indumentaria por ID", description = "Obtiene una prenda a partir de su identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indumentaria encontrada"),
            @ApiResponse(responseCode = "404", description = "Indumentaria no encontrada")
    })

    @GetMapping("/{id}")
    public ResponseEntity<IndumentariaResponseDTO> buscar(@PathVariable Integer id) {

        var indumentaria = service.buscarPorId(id);

        return ResponseEntity.ok(
                IndumentariaMapper.toDTO(indumentaria));
    }

    // POST - Crear
    @Operation(summary = "Crear indumentaria", description = "Registra una nueva prenda de indumentaria.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Indumentaria creada correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PostMapping
    public ResponseEntity<IndumentariaResponseDTO> guardar(
            @Valid @RequestBody IndumentariaRequestDTO dto) {

        var indumentaria = IndumentariaMapper.toEntity(dto);

        indumentaria = service.guardar(indumentaria);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(IndumentariaMapper.toDTO(indumentaria));
    }

    // PUT - Actualizar
    @Operation(summary = "Actualizar indumentaria", description = "Actualiza los datos de una prenda de indumentaria existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indumentaria actualizada correctamente"),
            @ApiResponse(responseCode = "404", description = "Indumentaria no encontrada")
    })

    @PutMapping("/{id}")
    public ResponseEntity<IndumentariaResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody IndumentariaRequestDTO dto) {

        var entidad = IndumentariaMapper.toEntity(dto);

        entidad = service.actualizar(id, entidad);

        return ResponseEntity.ok(
                IndumentariaMapper.toDTO(entidad));
    }

    // DELETE - Eliminar

    @Operation(summary = "Eliminar indumentaria", description = "Elimina una prenda de indumentaria por su identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indumentaria eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Indumentaria no encontrada")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponseDTO(true, "Indumentaria eliminada correctamente"));
    }

}
