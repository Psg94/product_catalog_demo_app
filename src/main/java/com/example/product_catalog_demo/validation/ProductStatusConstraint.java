package com.example.product_catalog_demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductStatusValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductStatusConstraint {
    String message() default "Invalid product status, must be 'ACTIVE' or 'INACTIVE'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}