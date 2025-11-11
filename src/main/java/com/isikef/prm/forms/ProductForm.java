package com.isikef.prm.forms;

import com.isikef.prm.entities.ProductCategory;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductForm {
    @NotEmpty(message = "name is required.")
    private String name;
    @NotNull(message = "Product's category is required.")
    private ProductCategory category;
    @NotEmpty(message = "Product description is required")
    @Size(min = 5,max = 1000, message = "Description's length should be between 5 and 1000 characters.")
    private String description;
    @Min(value = 1, message = "Product's price should be at last 1 dollar.")
    private double price;
    @Min(value = 1,message = "Product's quantity should be at last 1.")
    private int quantity;
}
