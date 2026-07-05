package com.ezequielriente.ecommerce.repository;

import com.ezequielriente.ecommerce.model.IndumentariaDeportiva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndumentariaRepository
        extends JpaRepository<IndumentariaDeportiva,Integer> {

}