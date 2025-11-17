package com.isikef.prm.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class ResponsePage {
    private int pageNumber;
    private int pageSize;
    private int totalElements;
    private int totalPages;

    public ResponsePage(int pageNumber, int pageSize, int totalElements, int totalPages) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public static ResponsePage of(Page page){
        return  new ResponsePage(
                page.getNumber(),
                page.getSize(),
                page.getNumberOfElements(),
                page.getTotalPages()
        );
    }
}
