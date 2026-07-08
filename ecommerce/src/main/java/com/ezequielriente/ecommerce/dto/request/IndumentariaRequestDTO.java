package com.ezequielriente.ecommerce.dto.request;

import com.ezequielriente.ecommerce.model.Talle;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Min;

public class IndumentariaRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Positive(message = "El precio debe ser mayor a cero")
    private Double precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotBlank(message = "La marca es obligatoria")
    private String marca;

    @NotNull(message = "Debe seleccionar un talle")
    private Talle talle;

    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;

    @NotBlank(message = "La imagen es obligatoria")
    private String imagenUrl;

    public IndumentariaRequestDTO() {
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