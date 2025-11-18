package com.isikef.prm.service;

import com.isikef.prm.entities.Comment;
import com.isikef.prm.entities.Product;
import com.isikef.prm.entities.ProductCategory;
import com.isikef.prm.exceptions.MissingEntityException;
import com.isikef.prm.forms.CommentSearchForm;
import com.isikef.prm.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CommentProductService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ProductService productService;

    public Comment addComment(Long productId, String content) throws MissingEntityException {
        Product product = productService.getProductById(productId);
        Comment comment = new Comment();
        comment.setProduct(product);
        comment.setContent(content);
        return commentRepository.save(comment);
    }

    public Page<Comment> getCommentsByProduct(CommentSearchForm form) throws MissingEntityException {
        Product product = productService.getProductById(form.getProductId());
        //Page<Comment> commentPage = commentRepository.findByProduct(product,form.getPageable());
        Page<Comment> commentPage = commentRepository.findByProductIdProduct(form.getProductId(), form.getPageable());
        return commentPage;
    }
}
