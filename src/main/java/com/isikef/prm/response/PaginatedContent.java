package com.isikef.prm.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
public class PaginatedContent {
    private Object items;
    private ResponsePage page;

    public PaginatedContent(Object content, ResponsePage page) {
        this.items = content;
        this.page = page;
    }

    public static PaginatedContent of(Object content, Page page){
        ResponsePage rPage = ResponsePage.of(page);
        return new PaginatedContent(content,rPage);
    }
}
