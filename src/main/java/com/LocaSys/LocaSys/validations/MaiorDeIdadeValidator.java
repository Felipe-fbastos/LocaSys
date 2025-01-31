package com.LocaSys.LocaSys.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;


public class MaiorDeIdadeValidator implements ConstraintValidator<MaiorDeIdade, LocalDate> {

    @Override
    public boolean isValid(LocalDate dtNascimento, ConstraintValidatorContext constraintValidatorContext) {
        //Pega o periodo entre a data de nascimento  e o dia de hoje e verifica se é maior de 18.
        return Period.between(dtNascimento,LocalDate.now()).getYears() >=18;
    }





}
