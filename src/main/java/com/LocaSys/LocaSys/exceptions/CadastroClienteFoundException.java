package com.LocaSys.LocaSys.exceptions;

import com.LocaSys.LocaSys.Entity.Cliente;
import com.LocaSys.LocaSys.Entity.Locacao;
import com.LocaSys.LocaSys.validations.EmissaoCNH;
import com.LocaSys.LocaSys.validations.EmissaoCNHValidator;
import com.LocaSys.LocaSys.validations.MaiorDeIdadeValidator;
import jakarta.validation.Payload;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;
import java.time.LocalDate;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CadastroClienteFoundException extends RuntimeException {



    public CadastroClienteFoundException(String campo){
        super(campo + "Já cadastrado");
    }

    public CadastroClienteFoundException(LocalDate idade, LocalDate dtEmissao){
        MaiorDeIdadeValidator maiorDeIdadeValidator = new MaiorDeIdadeValidator();
        EmissaoCNHValidator emissaoCNHValidator = new EmissaoCNHValidator();
        emissaoCNHValidator.isValid(dtEmissao);
        maiorDeIdadeValidator.isValid(idade);
    }

   }
