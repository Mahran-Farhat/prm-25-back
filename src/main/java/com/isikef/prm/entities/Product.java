package com.isikef.prm.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
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

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Comment> comments;
}
