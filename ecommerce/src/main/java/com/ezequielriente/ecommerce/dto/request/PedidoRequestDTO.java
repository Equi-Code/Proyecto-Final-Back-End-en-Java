// package com.ezequielriente.ecommerce.dto.request;

// import jakarta.validation.Valid;
// import jakarta.validation.constraints.NotEmpty;

// import java.util.List;

// public class PedidoRequestDTO {

//     @Valid
//     @NotEmpty(message = "Debe existir al menos una línea de pedido")
//     private List<LineaPedidoRequestDTO> lineas;

//     public List<LineaPedidoRequestDTO> getLineas() {
//         return lineas;
//     }

//     public void setLineas(List<LineaPedidoRequestDTO> lineas) {
//         this.lineas = lineas;
//     }
// }

package com.ezequielriente.ecommerce.dto.request;

import jakarta.validation.constraints.NotEmpty;
import java.util.List;

public class PedidoRequestDTO {

    @NotEmpty
    private List<LineaPedidoRequestDTO> lineas;

    public List<LineaPedidoRequestDTO> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedidoRequestDTO> lineas) {
        this.lineas = lineas;
    }

}