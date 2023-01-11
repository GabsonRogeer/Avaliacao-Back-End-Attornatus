package com.testeJava.attornatus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PessoaNotFoundException extends RuntimeException {
    public PessoaNotFoundException(Long id) {
        super("Não foi possível encontrar e pessoa com o id: " + id);
    }
}
