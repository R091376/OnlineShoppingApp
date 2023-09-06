package com.onlineshopping.productms.service;

import java.util.List;

import com.onlineshopping.productms.model.Product;

public interface ProductService {
    Product createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product updateProduct(Long id, Product updatedProduct);
    void deleteProduct(Long id);
}
