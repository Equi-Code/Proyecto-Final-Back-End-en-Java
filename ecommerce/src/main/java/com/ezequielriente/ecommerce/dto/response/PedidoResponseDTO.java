package com.ezequielriente.ecommerce.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {

    private Integer id;

    private LocalDateTime fecha;

    private String estado;

    private Double total;

    private List<LineaPedidoResponseDTO> lineas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<LineaPedidoResponseDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedidoResponseDTO> lineas) {
        this.lineas = lineas;
    }
}