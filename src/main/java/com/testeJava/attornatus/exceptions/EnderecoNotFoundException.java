package com.testeJava.attornatus.exceptions;

public class EnderecoNotFoundException extends RuntimeException{
    public EnderecoNotFoundException(Long id) {
        super("Não foi possível encontrar o endereço com o id: " + id);
    }
}
