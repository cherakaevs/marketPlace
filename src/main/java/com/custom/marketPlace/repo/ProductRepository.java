package com.custom.marketPlace.repo;

import com.custom.marketPlace.model.Product;

import java.util.UUID;

public interface ProductRepository {
    Product getProductById(UUID id);
    Product getProductByName(String name);
    Product saveProduct(Product p);
    void removeProduct(Product p);
    void updateProductName(UUID id, String name);
    void updateProductPrice(UUID id, Double price);
    void updateProductsCount(UUID id, Integer newCount);
}
