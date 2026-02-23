package com.example.fridge.exception;

public class FoodNotFoundException extends RuntimeException {
    public FoodNotFoundException(Long id) {
        super("Item com id " + id + " não encontrado na geladeira.");
    }
}