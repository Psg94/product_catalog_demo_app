package com.example.product_catalog_demo.controllers;

import com.example.product_catalog_demo.entities.ProductCategory;
import com.example.product_catalog_demo.services.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductCategoryController {
    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/categories")
    public String getAllProductCategories(@RequestParam(name = "name", required = false) String productCategoryName,
                                          @RequestParam(name = "description", required = false) String productCategoryDescr,
                                          Model model) {
        List<ProductCategory> productCategories = productCategoryService.getProductCategories(productCategoryName, productCategoryDescr);

        model.addAttribute("categories", productCategories);

        return "categories";
    }

    @GetMapping("/categories/{id}")
    public String getProductCategory(@PathVariable Long id, Model model) {
        ProductCategory productCategory = productCategoryService.getProductCategory(id);

        model.addAttribute("category", productCategory);

        return "category-info";
    }

    @PostMapping("/categories/create")
    public String saveProductCategory(ProductCategory productCategory) {
        productCategoryService.saveProductCategory(productCategory);

        return "redirect:/categories";
    }

    @PostMapping("/categories/update")
    public String updateProductCategory(@ModelAttribute("category") ProductCategory productCategory) {
        if (productCategory != null) {
            productCategoryService.updateProductCategory(productCategory);
        }

        return "redirect:/categories";
    }

    @PostMapping("/categories/delete/{id}")
    public String deleteProductCategory(@PathVariable Long id) {
        productCategoryService.deleteProductCategory(id);

        return "redirect:/categories";
    }
}
