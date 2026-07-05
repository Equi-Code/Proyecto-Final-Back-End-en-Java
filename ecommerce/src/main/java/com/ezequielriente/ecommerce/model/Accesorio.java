package com.ezequielriente.ecommerce.model;

import jakarta.persistence.Entity;

@Entity
public class Accesorio extends Producto {

    private String tipo;

    public Accesorio() {
    }

    public Accesorio(String nombre, Double precio, Integer stock, String tipo) {
        super(nombre, precio, stock);
        this.tipo = tipo;
    }

    @Override
    public String getCategoria() {
        return "Accesorio";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}