package com.isikef.prm.forms;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@ParameterObject
@Getter
@Setter
public class CommentSearchForm extends PageParams{

    @NotNull(message = "Product's ID is required.")
    private Long productId;
}
