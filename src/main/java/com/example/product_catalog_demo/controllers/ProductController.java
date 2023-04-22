package com.example.product_catalog_demo.controllers;

import com.example.product_catalog_demo.services.ProductService;
import com.example.product_catalog_demo.ui_display.ProductUiDisplay;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public String getProducts(@RequestParam(name = "name", required = false) String productName,
                              @RequestParam(name = "description", required = false) String productDescr,
                              @RequestParam(name = "priceFrom", required = false) Double priceFrom,
                              @RequestParam(name = "priceTo", required = false) Double priceTo,
                              Model model) {
        List<ProductUiDisplay> products= productService.getProducts(productName,
                                                                    productDescr,
                                                                    priceFrom,
                                                                    priceTo);

        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping("/products/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        ProductUiDisplay productUiDisplay = productService.getProduct(id);

        model.addAttribute("product", productUiDisplay);

        return "product-info";
    }

    @PostMapping("/products/create")
    public String saveProduct(@Valid ProductUiDisplay productUiDisplay,
                              @RequestParam("productImageFile") MultipartFile productImageFile) {
        productService.saveProduct(productUiDisplay, productImageFile);

        return "redirect:/products";
    }

    @PostMapping("/products/update")
    public String updateProduct(@Valid ProductUiDisplay productDisplay,
                                @RequestParam("productImageFile") MultipartFile productImageFile) {
        productService.updateProduct(productDisplay, productImageFile);

        return "redirect:/products";
    }

    @PostMapping("/products/delete/{id}")
    public String deleteProductCategory(@PathVariable Long id) {
        productService.deleteProduct(id);

        return "redirect:/products";
    }
}
