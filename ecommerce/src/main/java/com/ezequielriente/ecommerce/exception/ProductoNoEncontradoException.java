package com.ezequielriente.ecommerce.exception;

public class ProductoNoEncontradoException extends RuntimeException {

    public ProductoNoEncontradoException(Integer id) {
        super("No existe un producto con el ID: " + id);
    }

}
