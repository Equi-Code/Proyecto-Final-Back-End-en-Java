package com.ezequielriente.ecommerce.mapper;

import com.ezequielriente.ecommerce.dto.response.LineaPedidoResponseDTO;
import com.ezequielriente.ecommerce.dto.response.PedidoResponseDTO;
import com.ezequielriente.ecommerce.model.LineaPedido;
import com.ezequielriente.ecommerce.model.Pedido;

import java.util.stream.Collectors;

public class PedidoMapper {

    public static PedidoResponseDTO toDTO(Pedido pedido) {

        PedidoResponseDTO dto = new PedidoResponseDTO();

        dto.setId(pedido.getId());
        dto.setFecha(pedido.getFecha());
        dto.setEstado(pedido.getEstado());
        dto.setTotal(pedido.getTotal());

        dto.setLineas(
                pedido.getLineas()
                        .stream()
                        .map(PedidoMapper::toLineaDTO)
                        .collect(Collectors.toList())
        );

        return dto;
    }

    private static LineaPedidoResponseDTO toLineaDTO(LineaPedido linea) {

        LineaPedidoResponseDTO dto = new LineaPedidoResponseDTO();

        dto.setProductoId(linea.getProducto().getId());
        dto.setProducto(linea.getProducto().getNombre());
        dto.setCantidad(linea.getCantidad());
        dto.setPrecioUnitario(linea.getPrecioUnitario());

        dto.setSubtotal(
                linea.getCantidad() * linea.getPrecioUnitario()
        );

        return dto;
    }

}
