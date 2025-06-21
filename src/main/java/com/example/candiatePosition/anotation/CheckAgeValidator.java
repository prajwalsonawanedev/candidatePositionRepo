package com.example.candiatePosition.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.Period;

public class CheckAgeValidator implements ConstraintValidator<CheckAge, LocalDate> {
    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {

        if (dateOfBirth == null) {
            return true;
        }

        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 18;

    }
}
