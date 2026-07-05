package com.ezequielriente.ecommerce.exception;


public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String producto) {
        super("Stock insuficiente para el producto " + producto);
    }

}