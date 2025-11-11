package com.isikef.prm.service;

import com.isikef.prm.entities.Product;
import com.isikef.prm.entities.ProductCategory;
import com.isikef.prm.exceptions.MissingEntityException;
import com.isikef.prm.forms.PageParams;
import com.isikef.prm.forms.ProductForm;
import com.isikef.prm.forms.ProductSearchForm;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product saveProduct(ProductForm form);
    public Product getProductById(Long id) throws MissingEntityException;
    public void deleteProduct(Long id);
    public Product updateProduct(Long id, ProductForm form) throws MissingEntityException;
    public List<Product> searchByCategoryAndName(ProductSearchForm form);
    public Page<Product> paginatedProducts(PageParams params);
}
