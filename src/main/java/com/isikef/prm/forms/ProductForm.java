package com.isikef.prm.forms;

import com.isikef.prm.entities.ProductCategory;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    private String name;
    private ProductCategory category;
    private String description;
    private double price;
    private int quantity;
}
