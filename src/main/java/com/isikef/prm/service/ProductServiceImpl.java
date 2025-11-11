package com.isikef.prm.service;

import com.isikef.prm.entities.Product;
import com.isikef.prm.exceptions.MissingEntityException;
import com.isikef.prm.forms.PageParams;
import com.isikef.prm.forms.ProductForm;
import com.isikef.prm.forms.ProductSearchForm;
import com.isikef.prm.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

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
    public Product getProductById(Long id) throws MissingEntityException {
        return productRepository.findById(id).orElseThrow(
                ()-> new MissingEntityException("Product not found with ID : " + id + " or has been deleted")
        );
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            Product product = getProductById(id);
            productRepository.delete(product);
        } catch (MissingEntityException e) {
            log.info("NO product found with id :"+id);
        }

    }

    @Override
    public Product updateProduct(Long id, ProductForm form) throws MissingEntityException {
        Product product = getProductById(id);
        product.setName(product.getName());
        product.setDescription(form.getDescription());
        product.setCategory(form.getCategory());
        product.setPrice(form.getPrice());
        product.setStockQuantity(form.getQuantity());
        return productRepository.save(product);
    }

    @Override
    public Page<Product> paginatedProducts(PageParams params) {
        Pageable page = PageRequest.of(params.getPageNumber(), params.getPageSize());
        return productRepository.findAll(page);
    }

    @Override
    public List<Product> searchByCategoryAndName(ProductSearchForm form) {
        if(form.isAdvancedSearch())
            return productRepository.findByCategoryAndNameContains(form.getCategory(), form.getText());
        else
            return productRepository.findByCategory(form.getCategory());
    }
}
