package com.example.product_service.service;

import com.example.product_service.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ProductService {

    private final Map<Long, Product> products = new HashMap<>();

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public Product save(Product product) {
        products.put(product.id(), product);
        return product;
    }

    public void deleteById(Long id) {
        products.remove(id);
    }

}
