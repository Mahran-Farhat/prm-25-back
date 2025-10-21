package com.isikef.prm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ligne_commandes")
@Getter
@Setter
public class LigneCommande {
    // LigneCommande entity representing an order line item
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private int quantity;
    private double price;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "commande_id",
            referencedColumnName = "id")
    private Commande commande;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "product_id",
            referencedColumnName = "id")
    private Product product;
}
