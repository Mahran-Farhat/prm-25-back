package com.isikef.prm.dto;

import com.isikef.prm.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProductDto {
    private final Long id;
    private final String name;
    private final String category;
    private final String description;
    private final double price;
    private final int quantity;

    public ProductDto(Product product){
        this.id= product.getIdProduct();
        this.name = product.getName();
        this.category = product.getCategory().name();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.quantity = product.getStockQuantity();
    }

    public static ProductDto of(Product product){
        return product != null ? new ProductDto(product):null;
    }

    public static List<ProductDto> of(List<Product> products){
        return products.stream()
                .map(ProductDto::of)
                .collect(Collectors.toList());
    }

}
