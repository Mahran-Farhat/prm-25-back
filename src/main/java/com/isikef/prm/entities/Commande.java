package com.isikef.prm.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "commandes")
@Getter
@Setter
public class Commande {
    // Commande entity representing an order
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private String status;
    private java.util.Date orderDate;
    private java.util.Date deliveryDate;

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name = "member_id",
            referencedColumnName = "id")
    private Member member;
}
