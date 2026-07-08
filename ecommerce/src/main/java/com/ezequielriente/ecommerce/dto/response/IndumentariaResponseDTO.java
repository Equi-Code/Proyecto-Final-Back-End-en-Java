package com.ezequielriente.ecommerce.dto.response;

import com.ezequielriente.ecommerce.model.Talle;

public class IndumentariaResponseDTO {

    private Integer id;

    private String nombre;

    private Double precio;

    private Integer stock;

    private String marca;

    private Talle talle;

    private String categoria;
    private String descripcion;
private String imagenUrl;

    public IndumentariaResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Integer getStock() {
        return stock;
    }

    public String getMarca() {
        return marca;
    }

    public Talle getTalle() {
        return talle;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
    return descripcion;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public String getImagenUrl() {
    return imagenUrl;
}

public void setImagenUrl(String imagenUrl) {
    this.imagenUrl = imagenUrl;
}
}