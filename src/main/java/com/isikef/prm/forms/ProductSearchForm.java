package com.isikef.prm.forms;

import com.isikef.prm.entities.ProductCategory;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class ProductSearchForm {
    @NotNull(message = "Product category is mandatory.")
    private ProductCategory category;

    private String text;

    public boolean isAdvancedSearch(){
        return text != null && !text.isEmpty();
    }
}
