package com.isikef.prm.repository;

import com.isikef.prm.entities.Product;
import com.isikef.prm.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findByCategory(ProductCategory category);

    public List<Product> findByCategoryAndNameContains(ProductCategory category, String text);

    public int countByCategory(ProductCategory productCategory);

    @Query(value = "SELECT p from Product p where p.category = :category",nativeQuery = false)
    public int countProductsCategoryUsingJPQL(@Param("category") ProductCategory category);


    @Query(value = "SELECT p from products p where p.category = ?1",nativeQuery = true)
    public int countProductsCategoryUsingNative(ProductCategory category);

}
