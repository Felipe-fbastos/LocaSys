package com.LocaSys.LocaSys.validations;


import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class EmissaoCNHValidator implements ConstraintValidator<EmissaoCNH, LocalDate> {


    @Override
    public boolean isValid(LocalDate dtEmissao, ConstraintValidatorContext constraintValidatorContext) {
        return Period.between(dtEmissao, LocalDate.now()).getYears() >=2;
    }


}
