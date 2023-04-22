package com.example.product_catalog_demo.ui_display;

import com.example.product_catalog_demo.validation.PriceValueConstraint;
import com.example.product_catalog_demo.validation.ProductStatusConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.util.Base64;

public class ProductUiDisplay {
    private Long id;

    @NotBlank(message = "Product name must be not blank!")
    private String name;

    private String description;

    @PriceValueConstraint
    private String price;

    @Positive(message = "ID of category must be positive number!")
    private Long categoryId;

    private String creationDate;

    @ProductStatusConstraint
    private String status;

    private String imageDisplay;

    public ProductUiDisplay() {
    }

    public void setImageDisplay(byte[] imageBytes) {
        if (imageBytes != null) {
            byte[] encodedImageBytes = Base64.getEncoder().encode(imageBytes);
            String imageDataAsBase64 = new String(encodedImageBytes);
            imageDisplay = "data:image/png;base64," + imageDataAsBase64;
        } else {
            imageDisplay = null;
        }
    }

    public String getImageDisplay() {
        return imageDisplay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductUiDisplay{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", categoryId='" + categoryId + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
