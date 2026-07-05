package com.ezequielriente.ecommerce.repository;

import com.ezequielriente.ecommerce.model.Accesorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccesorioRepository
        extends JpaRepository<Accesorio, Integer> {
}