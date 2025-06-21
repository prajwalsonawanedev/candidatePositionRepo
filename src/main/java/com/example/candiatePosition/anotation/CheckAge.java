package com.example.candiatePosition.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = CheckAgeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckAge {

    String message() default "Candidate should be 18 years old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
