package com.isikef.prm.dto;

import com.isikef.prm.entities.Comment;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

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

    public static List<CommentDto> of(List<Comment> comments){
        return comments.stream().map(CommentDto::of).collect(Collectors.toList());
    }
}
