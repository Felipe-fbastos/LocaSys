package com.LocaSys.LocaSys.validations;

/*@Documented
Indica que essa anotação será incluída na documentação do JavaDoc.

@Constraint(validatedBy = MaiorDeIdadeValidator.class)
Especifica a classe que realizará a validação (nesse caso, MaiorDeIdadeValidator).

@Target(ElementType.FIELD)
Define onde a anotação pode ser usada.
Aqui está dizendo que só pode ser aplicada em campos (atributos de classe).

@Retention(RetentionPolicy.RUNTIME)
Indica que a anotação deve estar disponível em tempo de execução para que o Spring possa processá-la.*/

//PS: se @Constraint(validatedBy = {MaiorDeIdadeValidator.class}) não funcionar verifique se a classe validation está implementando esta classe com o tipo certo após a vigula.
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.time.LocalDate;

@Documented
@Constraint(validatedBy = {MaiorDeIdadeValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)

public @interface MaiorDeIdade {
    String message() default "O usuário deve ter pelo menos 18 anos";

    Class<?>[] groups() default {};  // Usado para agrupamento de validações

    Class<? extends Payload>[] payload() default {}; // Informações extras para clientes de validação



}

