package com.ezequielriente.ecommerce.repository;

import com.ezequielriente.ecommerce.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}