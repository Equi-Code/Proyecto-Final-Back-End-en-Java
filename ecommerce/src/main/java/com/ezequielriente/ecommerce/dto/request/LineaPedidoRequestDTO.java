// package com.ezequielriente.ecommerce.dto.request;

// import jakarta.validation.constraints.Min;
// import jakarta.validation.constraints.NotNull;

// public class LineaPedidoRequestDTO {

//     @NotNull(message = "El producto es obligatorio")
//     private Integer productoId;

//     @NotNull(message = "La cantidad es obligatoria")
//     @Min(value = 1, message = "La cantidad debe ser mayor a cero")
//     private Integer cantidad;

//     public Integer getProductoId() {
//         return productoId;
//     }

//     public void setProductoId(Integer productoId) {
//         this.productoId = productoId;
//     }

//     public Integer getCantidad() {
//         return cantidad;
//     }

//     public void setCantidad(Integer cantidad) {
//         this.cantidad = cantidad;
//     }
// }

package com.ezequielriente.ecommerce.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class LineaPedidoRequestDTO {

    @NotNull
    private Integer productoId;

    @NotNull
    @Min(1)
    private Integer cantidad;

    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
