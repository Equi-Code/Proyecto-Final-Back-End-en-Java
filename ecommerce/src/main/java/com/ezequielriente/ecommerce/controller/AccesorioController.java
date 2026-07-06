package com.ezequielriente.ecommerce.controller;

import com.ezequielriente.ecommerce.model.Accesorio;
import com.ezequielriente.ecommerce.service.AccesorioService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import com.ezequielriente.ecommerce.dto.request.AccesorioRequestDTO;
import com.ezequielriente.ecommerce.dto.response.AccesorioResponseDTO;

import com.ezequielriente.ecommerce.mapper.AccesorioMapper;

import com.ezequielriente.ecommerce.response.ApiResponseDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/accesorios")
public class AccesorioController {

    private final AccesorioService service;

    public AccesorioController(AccesorioService service) {
        this.service = service;
    }

    // GET - Listar todos
    @Operation(summary = "Listar accesorios", description = "Obtiene el listado completo de accesorios registrados.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Listado obtenido correctamente")
    })
        @GetMapping
        public Page<AccesorioResponseDTO> listar(

                        @RequestParam(defaultValue = "0") int page,

                        @RequestParam(defaultValue = "10") int size

        ) {

                Pageable pageable = PageRequest.of(page, size);

                return service.listar(pageable)
                                .map(AccesorioMapper::toDTO);
        }

    // GET - Buscar por ID

    @Operation(summary = "Buscar accesorio por ID", description = "Obtiene un accesorio a partir de su identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accesorio encontrado"),
            @ApiResponse(responseCode = "404", description = "Accesorio no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<AccesorioResponseDTO> buscar(@PathVariable Integer id) {

        var accesorio = service.buscarPorId(id);

        return ResponseEntity.ok(
                AccesorioMapper.toDTO(accesorio));
    }

    // POST - Crear

    @Operation(summary = "Crear accesorio", description = "Registra un nuevo accesorio.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Accesorio creado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })

    @PostMapping
    public ResponseEntity<AccesorioResponseDTO> guardar(
            @Valid @RequestBody AccesorioRequestDTO dto) {

        var accesorio = AccesorioMapper.toEntity(dto);

        accesorio = service.guardar(accesorio);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(AccesorioMapper.toDTO(accesorio));
    }

    // PUT - Actualizar

    @Operation(summary = "Actualizar accesorio", description = "Actualiza los datos de un accesorio existente.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accesorio actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Accesorio no encontrado")
    })

    @PutMapping("/{id}")
    public ResponseEntity<Accesorio> actualizar(
            @PathVariable Integer id,
            @RequestBody Accesorio accesorio) {

        Accesorio actualizado = service.actualizar(id, accesorio);

        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(actualizado);
    }

    // DELETE - Eliminar
    @Operation(summary = "Eliminar accesorio", description = "Elimina un accesorio por su identificador.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Accesorio eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Accesorio no encontrado")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> eliminar(@PathVariable Integer id) {

        service.eliminar(id);

        return ResponseEntity.ok(
                new ApiResponseDTO(true, "Accesorio eliminado correctamente"));
    }

}