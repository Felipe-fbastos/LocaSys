package com.LocaSys.LocaSys.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {EmissaoCNHValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface EmissaoCNH {

    String message() default "Você precisa estar habilitado a mais de 2 anos";

    Class<?>[] groups() default {};  // Usado para agrupamento de validações

    Class<? extends Payload>[] payload() default {}; // Informações extras para clientes de validação


}
