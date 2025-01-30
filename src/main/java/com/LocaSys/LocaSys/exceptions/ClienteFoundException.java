package com.LocaSys.LocaSys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ClienteFoundException extends RuntimeException {

    public ClienteFoundException(String campo, String valor){
        super("Cliente com " + campo + " " + valor+  " não encontrado");

    }

    public ClienteFoundException(String campo, int valor){
        super("Cliente com " + campo + " " + valor + " não encontrado");
    }
}
