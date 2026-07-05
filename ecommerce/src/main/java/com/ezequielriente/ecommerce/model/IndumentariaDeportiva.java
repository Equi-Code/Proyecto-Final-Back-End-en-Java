package com.ezequielriente.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class IndumentariaDeportiva extends Producto {

    private String marca;

    @Enumerated(EnumType.STRING)
    private Talle talle;

    public IndumentariaDeportiva() {
    }

    public IndumentariaDeportiva(
            String nombre,
            Double precio,
            Integer stock,
            String marca,
            Talle talle) {

        super(nombre, precio, stock);
        this.marca = marca;
        this.talle = talle;
    }

    @Override
    public String getCategoria() {
        return "Indumentaria";
    }

    public String getMarca() {
        return marca;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }
}
