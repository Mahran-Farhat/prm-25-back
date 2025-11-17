package com.isikef.prm.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
@Setter
public class AppResponse {
    private HttpResponseStatus status;
    private String message;
    private Object content;

    public AppResponse(HttpResponseStatus status, String message, Object content){
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public static ResponseEntity success(String message, Object content){
        AppResponse response = new AppResponse(HttpResponseStatus.SUCCESS,message,content);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity success(String message, Object content, Page page){
        PaginatedContent pContent = PaginatedContent.of(content,page);
        AppResponse response = new AppResponse(HttpResponseStatus.SUCCESS,message,pContent);
        return ResponseEntity.ok(response);
    }

    public static ResponseEntity error(String message){
        AppResponse response = new AppResponse(HttpResponseStatus.ERROR,message,null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    public static ResponseEntity success(String message){
        AppResponse response = new AppResponse(HttpResponseStatus.SUCCESS,message,null);
        return ResponseEntity.ok(response);
    }
}
