package com.ezequielriente.ecommerce.dto.response;

import com.ezequielriente.ecommerce.model.EstadoPedido;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {

    private Integer id;
    private LocalDateTime fecha;
    private EstadoPedido estado;
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

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
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
