package com.example.product_catalog_demo.services;

import com.example.product_catalog_demo.entities.ProductCategory;
import com.example.product_catalog_demo.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    private boolean isParameterFilled(String parameterValue) {
        return parameterValue != null && !parameterValue.isEmpty();
    }

    public List<ProductCategory> getProductCategories(String productCategoryName, String productCategoryDescr) {
        List<ProductCategory> productCategories = null;

        if (!isParameterFilled(productCategoryName) && !isParameterFilled(productCategoryDescr)) {
            productCategories = productCategoryRepository.findAll();
        } else {
            String nameMask = productCategoryName.isEmpty()? "%": productCategoryName;
            String descriptionMask = productCategoryDescr.isEmpty()? "%": productCategoryDescr;

            productCategories = productCategoryRepository.findAllByNameAndDescription(nameMask, descriptionMask);
        }

        return productCategories;
    }

    public ProductCategory getProductCategory(Long id) {
        ProductCategory productCategory = productCategoryRepository.findAllById(id).orElse(null);
        return productCategory;
    }

    public void saveProductCategory(ProductCategory productCategory) {
        productCategoryRepository.save(productCategory);
    }

    public void updateProductCategory(ProductCategory productCategory) {
        if (productCategory != null) {
            ProductCategory repoProductCategory = productCategoryRepository.findAllById(productCategory.getId()).orElse(null);

            if (repoProductCategory != null) {
                if (isParameterFilled(productCategory.getName())) {
                    repoProductCategory.setName(productCategory.getName());
                }

                if (isParameterFilled(productCategory.getDescription())) {
                    repoProductCategory.setDescription(productCategory.getDescription());
                }

                productCategoryRepository.save(repoProductCategory);
            }
        }
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
