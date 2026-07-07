package com.ezequielriente.ecommerce.dto.request;

import jakarta.validation.constraints.NotBlank;

public class EstadoPedidoRequestDTO {

    @NotBlank
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}