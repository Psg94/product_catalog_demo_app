package com.example.product_catalog_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ProductStatusValidator implements
        ConstraintValidator<ProductStatusConstraint, String> {

    @Override
    public void initialize(ProductStatusConstraint productStatusConstraint) {
    }

    @Override
    public boolean isValid(String productStatusField,
                           ConstraintValidatorContext cxt) {
        return ProductStatus.isStatusCodeValid(productStatusField);
    }
}