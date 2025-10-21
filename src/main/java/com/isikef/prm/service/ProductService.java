package com.isikef.prm.service;

import com.isikef.prm.entities.Product;
import com.isikef.prm.forms.ProductForm;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product saveProduct(ProductForm form);
    public Product getProductById(Long id);
    public void deleteProduct(Long id);
    public Product updateProduct(Long id, ProductForm form);
}
