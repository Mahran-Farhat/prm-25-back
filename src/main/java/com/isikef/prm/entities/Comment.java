package com.isikef.prm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "comments")
@Getter
@Setter
@Where(clause = " disabled = false ")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private boolean disabled;
}
