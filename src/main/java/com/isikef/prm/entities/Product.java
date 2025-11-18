package com.isikef.prm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
@Where(clause = " disabled = false ")
public class Product {
    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    @Column(name = "name",nullable = false, length = 100, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private ProductCategory category;

    private int stockQuantity;

    private boolean disabled;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Comment> comments;
}
