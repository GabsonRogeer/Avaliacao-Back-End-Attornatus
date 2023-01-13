package com.testeJava.attornatus.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EnderecoNotFoundException extends RuntimeException{
    public EnderecoNotFoundException(Long id) {
        super("Não foi possível encontrar o endereço com o id: " + id);
    }
}
