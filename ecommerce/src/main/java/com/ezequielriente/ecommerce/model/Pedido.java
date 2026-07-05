package com.ezequielriente.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    private Double total = 0.0;

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineas = new ArrayList<>();

    public Pedido() {
        this.fecha = LocalDateTime.now();
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(LocalDateTime fecha, EstadoPedido estado) {
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public void setLineas(List<LineaPedido> lineas) {
        this.lineas = lineas;
    }

}
