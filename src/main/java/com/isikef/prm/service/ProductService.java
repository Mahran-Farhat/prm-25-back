package com.isikef.prm.service;

import com.isikef.prm.entities.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product saveProduct(Product product);
    public Product getProductById(Long id);
}
