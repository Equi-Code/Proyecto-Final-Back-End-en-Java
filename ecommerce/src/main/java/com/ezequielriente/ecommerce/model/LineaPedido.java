package com.ezequielriente.ecommerce.model;

import jakarta.persistence.*;

@Entity
public class LineaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    private Integer cantidad;

    private Double precioUnitario;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public LineaPedido() {
    }

    public LineaPedido(
            Producto producto,
            Pedido pedido,
            Integer cantidad,
            Double precioUnitario) {

        this.producto = producto;
        this.pedido = pedido;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Integer getId() {
        return id;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}