package com.isikef.prm.dto;

import com.isikef.prm.entities.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long id;
    private String content;

    public CommentDto(Comment comment){
        this.id = comment.getId();
        this.content = comment.getContent();
    }

    public static CommentDto of(Comment comment){
        return  comment == null ? null: new CommentDto(comment);
    }
}
