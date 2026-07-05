package com.ezequielriente.ecommerce.service;

import com.ezequielriente.ecommerce.model.Producto;
import com.ezequielriente.ecommerce.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("null") // Silencia todas las advertencias de nulidad estrictas en esta clase
public class ProductoService {

    private final ProductoRepository repository;

    public ProductoService(ProductoRepository repository) {
        this.repository = repository;
    }

    public List<Producto> listar() {
        return repository.findAll();
    }

    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    public Producto buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con el ID: " + id));
    }

    public void eliminar(Integer id) {
        buscarPorId(id); 
        repository.deleteById(id);
    }
}