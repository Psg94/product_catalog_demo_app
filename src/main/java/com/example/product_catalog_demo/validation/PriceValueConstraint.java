package com.example.product_catalog_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PriceValueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PriceValueConstraint {
    String message() default "Invalid price value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
