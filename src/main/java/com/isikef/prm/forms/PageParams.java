package com.isikef.prm.forms;

import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@ParameterObject
public class PageParams {
    private int pageSize = 10;
    private int pageNumber = 1;

    public Pageable getPageable(){
        return PageRequest.of(pageNumber-1,pageSize);
    }
}
