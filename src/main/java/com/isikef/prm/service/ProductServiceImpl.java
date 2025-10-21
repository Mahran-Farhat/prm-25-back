package com.isikef.prm.service;

import com.isikef.prm.entities.Product;
import com.isikef.prm.forms.ProductForm;
import com.isikef.prm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(ProductForm form) {
        Product product = new Product();
        product.setName(form.getName());
        product.setCategory(form.getCategory());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getQuantity());
        product.setDescription(form.getDescription());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    @Override
    public Product updateProduct(Long id, ProductForm form) {
        Product product = getProductById(id);
        product.setName(product.getName());
        product.setDescription(form.getDescription());
        product.setCategory(form.getCategory());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getQuantity());
        return productRepository.save(product);
    }
}
