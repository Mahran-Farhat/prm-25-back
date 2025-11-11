package com.isikef.prm.forms;

import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;

@Getter
@Setter
@ParameterObject
public class PageParams {
    private int pageSize = 10;
    private int pageNumber = 0;
}
