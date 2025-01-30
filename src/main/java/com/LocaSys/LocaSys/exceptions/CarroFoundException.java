package com.LocaSys.LocaSys.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CarroFoundException extends RuntimeException{

    public CarroFoundException(String campo, String valor){
        super("Carro com o " + campo + " " + valor + " não encontrado");

    }

    public CarroFoundException(String campo, int valor){
        super("Carro com o " + campo + " " + valor + " não encontrado");
    }

}
