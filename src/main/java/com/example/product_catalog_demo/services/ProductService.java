package com.example.product_catalog_demo.services;

import com.example.product_catalog_demo.entities.Product;
import com.example.product_catalog_demo.entities.ProductCategory;
import com.example.product_catalog_demo.exception_handling.NoSuchCategoryException;
import com.example.product_catalog_demo.repositories.ProductCategoryRepository;
import com.example.product_catalog_demo.repositories.ProductRepository;
import com.example.product_catalog_demo.ui_display.ProductUiDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    private boolean isParameterFilled(String parameterValue) {
        return parameterValue != null && !parameterValue.isEmpty();
    }

    private boolean isNumberParameterFilled(Number parameterValue) {
        return parameterValue != null;
    }

    private ProductUiDisplay toProductUiDisplay(Product product) {
        if (product == null) {
            return null;
        }

        ProductUiDisplay productUiDisplay = new ProductUiDisplay();

        productUiDisplay.setId(product.getId());
        productUiDisplay.setName(product.getName());
        productUiDisplay.setDescription(product.getDescription());
        productUiDisplay.setPrice(String.valueOf(product.getPrice()));
        productUiDisplay.setCategoryId((product.getProductCategory() == null)? null: product.getProductCategory().getId());
        productUiDisplay.setImageDisplay(product.getImageBytes());
        productUiDisplay.setCreationDate(product.getCreationDate().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        productUiDisplay.setStatus(product.getStatus());

        return productUiDisplay;
    }

    private void copyProductUpdatableFieldsOnly(ProductUiDisplay fromProductUiDisplay, Product toProduct) {
        toProduct.setId(fromProductUiDisplay.getId());
        toProduct.setName(fromProductUiDisplay.getName());
        toProduct.setDescription(fromProductUiDisplay.getDescription());
        toProduct.setPrice((fromProductUiDisplay.getPrice() == null)? 0: Double.parseDouble(fromProductUiDisplay.getPrice()));

        ProductCategory productCategory = productCategoryRepository.findAllById(fromProductUiDisplay.getCategoryId()).orElse(null);
        toProduct.setProductCategory(productCategory);

        toProduct.setStatus(fromProductUiDisplay.getStatus());

        //Image: don't copy - no need here
    }

    private Product toProduct(ProductUiDisplay productUiDisplay) {
        if (productUiDisplay == null) {
            return null;
        }

        Product product = new Product();

        copyProductUpdatableFieldsOnly(productUiDisplay, product);

        if (productUiDisplay.getCreationDate() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDateTime creationDate = LocalDateTime.parse(productUiDisplay.getCreationDate(), formatter);
            product.setCreationDate(creationDate);
        }

        product.setStatus(productUiDisplay.getStatus());

        return product;
    }

    public List<ProductUiDisplay> getProducts(String productName,
                                              String productDescr,
                                              Double priceFrom,
                                              Double priceTo) {
        List<ProductUiDisplay> products = null;

        if (!isParameterFilled(productName) &&
                !isParameterFilled(productDescr) &&
                !isNumberParameterFilled(priceFrom) &&
                !isNumberParameterFilled(priceTo)) {
            products = productRepository.findAll()
                    .stream().map(product -> toProductUiDisplay(product)).collect(Collectors.toList());
        } else {
            products = productRepository.findByNameOrDescriptionOrPriceBetween(productName,
                    productDescr,
                    priceFrom,
                    priceTo)
                    .stream().map(product -> toProductUiDisplay(product)).collect(Collectors.toList());
        }

        return products;
    }

    public ProductUiDisplay getProduct(Long id) {
        Product product = productRepository.findAllById(id).orElse(null);

        ProductUiDisplay productUiDisplay = (product == null)? null: toProductUiDisplay(product);

        return productUiDisplay;
    }

    public void saveProduct(ProductUiDisplay productUiDisplay, MultipartFile productImageFile) {

        ProductCategory productCategory = productCategoryRepository.findAllById(productUiDisplay.getCategoryId()).orElse(null);

        if (productCategory == null) {
            throw new NoSuchCategoryException("Product category with ID = " + productUiDisplay.getCategoryId() +
                                              " doesn't exists!");
        }

        Product product = toProduct(productUiDisplay);

        try {
            product.setImageBytes(productImageFile.getBytes());
        } catch (IOException e) {
            //Product without image is allowed
        }

        productRepository.save(product);
    }

    public void updateProduct(ProductUiDisplay productUiDisplay, MultipartFile productImageFile) {
        if (productUiDisplay != null) {
            Product repoProduct = productRepository.findAllById(productUiDisplay.getId()).orElse(null);

            if (repoProduct != null) {
                copyProductUpdatableFieldsOnly(productUiDisplay, repoProduct);

                try {
                    if(productImageFile.getBytes().length > 0) {
                        repoProduct.setImageBytes(productImageFile.getBytes());
                    }
                } catch (IOException e) {
                    //Product without image is allowed
                }

                productRepository.save(repoProduct);
            }
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
