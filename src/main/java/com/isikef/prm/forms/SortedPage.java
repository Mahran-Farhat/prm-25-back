package com.isikef.prm.forms;

import lombok.Getter;
import lombok.Setter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ParameterObject
public class SortedPage extends PageParams {
    private String sortField;
    private SortOrder order;

    public Sort getSort(){
        if(sortField != null && !sortField.isEmpty()) {
            if(order == null)
            return Sort.by(sortField.toString()).ascending();
            else {
                switch (order) {
                    case ASC:
                        return Sort.by(sortField.toString()).ascending();
                    case DES:
                        return Sort.by(sortField.toString()).descending();
                    default:
                        throw new IllegalArgumentException("Sort order is not supported :" + order);
                }
            }
        }
        return null;
    }
}
