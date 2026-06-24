package com.example.product_service;

import com.example.product_service.model.Product;
import com.example.product_service.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void findAllReturnsEmptyList() {
        assertTrue(productService.findAll().isEmpty());
    }

    @Test
    void saveAndFindById() {

        Product product =
                new Product(
                        1L,
                        "Laptop",
                        "Dell",
                        BigDecimal.valueOf(1000),
                        "Electronics"
                );

        productService.save(product);

        assertTrue(productService.findById(1L).isPresent());
    }

    @Test
    void findByIdReturnsEmpty() {

        assertTrue(
                productService.findById(100L)
                        .isEmpty()
        );
    }

    @Test
    void deleteByIdRemovesProduct() {

        Product product =
                new Product(
                        1L,
                        "Laptop",
                        "Dell",
                        BigDecimal.valueOf(1000),
                        "Electronics"
                );

        productService.save(product);

        assertTrue(productService.findById(1L).isPresent());

        productService.deleteById(1L);

        assertTrue(productService.findById(1L).isEmpty());
    }


    @Test
    void findAllReturnsAllSavedProducts() {

        Product p1 =
                new Product(
                        1L,
                        "Laptop",
                        "Dell",
                        BigDecimal.valueOf(1000),
                        "Electronics"
                );

        Product p2 =
                new Product(
                        2L,
                        "Phone",
                        "Samsung",
                        BigDecimal.valueOf(800),
                        "Electronics"
                );

        productService.save(p1);
        productService.save(p2);

        List<Product> products = productService.findAll();

        assertEquals(2, products.size());
    }


}
