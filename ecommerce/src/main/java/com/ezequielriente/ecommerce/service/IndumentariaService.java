package com.ezequielriente.ecommerce.service;

import com.ezequielriente.ecommerce.exception.ProductoNoEncontradoException;
import com.ezequielriente.ecommerce.model.IndumentariaDeportiva;
import com.ezequielriente.ecommerce.repository.IndumentariaRepository;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@SuppressWarnings("null")
public class IndumentariaService {

    private final IndumentariaRepository repository;

    public IndumentariaService(IndumentariaRepository repository) {
        this.repository = repository;
    }

    public List<IndumentariaDeportiva> listar() {
        return repository.findAll();
    }

    public IndumentariaDeportiva buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductoNoEncontradoException(id));
    }

    public IndumentariaDeportiva guardar(IndumentariaDeportiva indumentaria) {
        return repository.save(indumentaria);
    }

    public IndumentariaDeportiva actualizar(Integer id,
                                            IndumentariaDeportiva indumentariaActualizada) {

        IndumentariaDeportiva indumentaria = buscarPorId(id);

        indumentaria.setNombre(indumentariaActualizada.getNombre());
        indumentaria.setPrecio(indumentariaActualizada.getPrecio());
        indumentaria.setStock(indumentariaActualizada.getStock());
        indumentaria.setMarca(indumentariaActualizada.getMarca());
        indumentaria.setTalle(indumentariaActualizada.getTalle());

        return repository.save(indumentaria);
    }

    public boolean eliminar(Integer id) {
        try {
            IndumentariaDeportiva indumentaria = buscarPorId(id);
            repository.delete(indumentaria);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public Page<IndumentariaDeportiva> listar(Pageable pageable) {
    return repository.findAll(pageable);
}
}