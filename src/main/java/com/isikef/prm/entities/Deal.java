package com.isikef.prm.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "deals")
@Getter
@Setter
public class Deal {
    // Deal entity representing a special offer or discount
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int discount;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
