package com.ezequielriente.ecommerce.service;

import com.ezequielriente.ecommerce.exception.ProductoNoEncontradoException;
import com.ezequielriente.ecommerce.exception.StockInsuficienteException;
import com.ezequielriente.ecommerce.model.Pedido;
import com.ezequielriente.ecommerce.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import com.ezequielriente.ecommerce.repository.ProductoRepository;

import com.ezequielriente.ecommerce.dto.request.PedidoRequestDTO;
import com.ezequielriente.ecommerce.dto.request.LineaPedidoRequestDTO;
import com.ezequielriente.ecommerce.dto.response.PedidoResponseDTO;
import com.ezequielriente.ecommerce.mapper.PedidoMapper;
import com.ezequielriente.ecommerce.model.LineaPedido;
import com.ezequielriente.ecommerce.model.Producto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@SuppressWarnings("null")

public class PedidoService {

    private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

    private final PedidoRepository repository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository repository,
            ProductoRepository productoRepository) {

        this.repository = repository;
        this.productoRepository = productoRepository;
    }

    public List<Pedido> listar() {
        return repository.findAll();
    }

    public Pedido buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);

    }

    @Transactional
    public PedidoResponseDTO guardar(PedidoRequestDTO dto) {

        logger.info("Iniciando creación de un nuevo pedido");

        Pedido pedido = new Pedido();

        double total = 0.0;

        for (LineaPedidoRequestDTO lineaDTO : dto.getLineas()) {

            Producto producto = productoRepository.findById(lineaDTO.getProductoId())
                    .orElseThrow(() -> {
    logger.error(
            "Producto {} inexistente",
            lineaDTO.getProductoId());

    return new ProductoNoEncontradoException(lineaDTO.getProductoId());
});

            logger.info(
                    "Procesando producto: {} - Cantidad: {}",
                    producto.getNombre(),
                    lineaDTO.getCantidad());

            if (producto.getStock() < lineaDTO.getCantidad()) {

                logger.warn(
                        "Stock insuficiente para {}. Stock: {} - Solicitado: {}",
                        producto.getNombre(),
                        producto.getStock(),
                        lineaDTO.getCantidad());

                throw new StockInsuficienteException(producto.getNombre());

            }

            LineaPedido linea = new LineaPedido();

            linea.setPedido(pedido);
            linea.setProducto(producto);
            linea.setCantidad(lineaDTO.getCantidad());
            linea.setPrecioUnitario(producto.getPrecio());

            pedido.getLineas().add(linea);

            total += producto.getPrecio() * lineaDTO.getCantidad();

            producto.setStock(
                    producto.getStock() - lineaDTO.getCantidad());

            productoRepository.save(producto);
            logger.info(
                    "Stock actualizado de {}. Nuevo stock: {}",
                    producto.getNombre(),
                    producto.getStock());

        }

        pedido.setTotal(total);

        Pedido pedidoGuardado = repository.save(pedido);

        logger.info(
                "Pedido {} creado correctamente. Total: ${}",
                pedidoGuardado.getId(),
                pedidoGuardado.getTotal());

        return PedidoMapper.toDTO(pedidoGuardado);
    }

    public Pedido actualizar(Integer id, Pedido pedidoActualizado) {

        Pedido pedido = buscarPorId(id);

        pedido.setEstado(pedidoActualizado.getEstado());

        return repository.save(pedido);
    }

    public boolean eliminar(Integer id) {

        try {

            Pedido pedido = buscarPorId(id);

            repository.delete(pedido);

            return true;

        } catch (RuntimeException e) {

            return false;
        }
    }

}
