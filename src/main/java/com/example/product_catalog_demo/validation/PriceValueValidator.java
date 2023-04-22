package com.example.product_catalog_demo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValueValidator implements
        ConstraintValidator<PriceValueConstraint, String> {

    @Override
    public void initialize(PriceValueConstraint priceValueConstraint) {
    }

    @Override
    public boolean isValid(String priceField,
                           ConstraintValidatorContext cxt) {
        boolean validationPassed = true;

        try {
            double price = Double.parseDouble(priceField);

            validationPassed = (price > 0);
        } catch(Exception e) {
            validationPassed = false;
        }

        return validationPassed;
    }
}
