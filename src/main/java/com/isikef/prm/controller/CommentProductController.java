package com.isikef.prm.controller;

import com.isikef.prm.dto.CommentDto;
import com.isikef.prm.entities.Comment;
import com.isikef.prm.exceptions.MissingEntityException;
import com.isikef.prm.forms.CommentSearchForm;
import com.isikef.prm.response.AppResponse;
import com.isikef.prm.service.CommentProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment-product")
public class CommentProductController {

    @Autowired
    CommentProductService commentProductService;

    @Operation(summary = "Comment product", description = "Add a product's comment. "+
    "The product's id and the comment's content are required.")
    @PostMapping(value="/create")
    public ResponseEntity addComment(
            @Parameter Long productId,
            @Parameter String content
    ) throws MissingEntityException {
        Comment comment = commentProductService.addComment(productId, content);
        return AppResponse.success("Comment successfully added.", CommentDto.of(comment));
    }

    @GetMapping("/fetch")
    public ResponseEntity getProductComments(@ModelAttribute CommentSearchForm form) throws MissingEntityException {
        Page<Comment> page = commentProductService.getCommentsByProduct(form);
        List<CommentDto> commentDtoList = CommentDto.of(page.getContent());
        return AppResponse.success(null,commentDtoList,page);
    }
}
