package com.isikef.prm.repository;

import com.isikef.prm.entities.Product;
import com.isikef.prm.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByCategory(ProductCategory category);

    public List<Product> findByCategoryAndNameContains(ProductCategory category, String text);
}
