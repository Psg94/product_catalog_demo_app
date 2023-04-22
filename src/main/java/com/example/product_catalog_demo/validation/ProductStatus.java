package com.example.product_catalog_demo.validation;

import com.example.product_catalog_demo.entities.Product;

import java.util.Arrays;

public enum ProductStatus {

    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private static String statusCodeValues;
    private String statusCode;

    private ProductStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public static boolean isStatusCodeValid(String statusCode) {
        for (ProductStatus productStatus: ProductStatus.values()) {
            if (productStatus.getStatusCode().equals(statusCode)) {
                return true;
            }
        }

        return false;
    }

    public static String getStatusCodeValues() {
        if (statusCodeValues == null) {
            statusCodeValues = Arrays.asList(ProductStatus.values()).toString();
        }

        return statusCodeValues;
    }
}
