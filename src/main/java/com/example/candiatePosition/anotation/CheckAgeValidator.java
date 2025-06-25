package com.example.candiatePosition.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Period;

@Slf4j
public class CheckAgeValidator implements ConstraintValidator<CheckAge, LocalDate> {
    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {

        if (dateOfBirth == null) {
            log.info("dateOfBirth field is Empty");
            return true;
        }

        return Period.between(dateOfBirth, LocalDate.now()).getYears() >= 18;

    }
}
