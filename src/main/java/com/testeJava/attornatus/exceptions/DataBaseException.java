package com.testeJava.attornatus.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DataBaseException extends RuntimeException{
    public DataBaseException(String msg){
        super(msg);
    }
}
