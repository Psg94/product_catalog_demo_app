package com.example.product_catalog_demo.exception_handling;

public class ExceptionInfo {
    private String errorMessage;

    public ExceptionInfo() {
    }

    public ExceptionInfo(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
