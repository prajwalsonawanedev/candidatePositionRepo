package com.example.candiatePosition.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(validatedBy = NullOrNotBlankValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NullOrNotBlank {
    String message() default "Null or Blank value not allowed";
    Class<?>[] groups() default {};
    int min() default 0;
    int max() default 0;
    String isMandatory() default "yes";
    String isEmail() default "no";
    Class<? extends Payload>[] payload() default {};
}