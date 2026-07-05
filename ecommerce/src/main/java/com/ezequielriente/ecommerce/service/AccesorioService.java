package com.ezequielriente.ecommerce.service;

import com.ezequielriente.ecommerce.model.Accesorio;
import com.ezequielriente.ecommerce.repository.AccesorioRepository;
import org.springframework.stereotype.Service;
import com.ezequielriente.ecommerce.exception.ProductoNoEncontradoException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@SuppressWarnings("null") // Silencia todas las advertencias de nulidad estrictas en esta clase
public class AccesorioService {

    private final AccesorioRepository repository;

    public AccesorioService (AccesorioRepository repository) {
        this.repository = repository;
    }

    public List<Accesorio> listar() {
        return repository.findAll();
    }

public Accesorio buscarPorId(Integer id) {
    return repository.findById(id)
            .orElseThrow(() -> new ProductoNoEncontradoException(id));
}

    public Accesorio guardar(Accesorio accesorio) {
        return repository.save(accesorio);
    }

    public Accesorio actualizar(Integer id, Accesorio accesorioActualizado) {
        Accesorio accesorio = buscarPorId(id);

        accesorio.setNombre(accesorioActualizado.getNombre());
        accesorio.setPrecio(accesorioActualizado.getPrecio());
        accesorio.setStock(accesorioActualizado.getStock());
        accesorio.setTipo(accesorioActualizado.getTipo());

        return repository.save(accesorio);
    }

    public boolean eliminar(Integer id) {
        try {
            Accesorio accesorio = buscarPorId(id);
            repository.delete(accesorio);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Page<Accesorio> listar(Pageable pageable) {
    return repository.findAll(pageable);
}
}
