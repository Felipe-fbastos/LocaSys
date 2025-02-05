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

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CadastroClienteFoundException extends RuntimeException {



  public CadastroClienteFoundException(String cpf){
       super( cpf + " CPF já cadastrado");
   }


   }