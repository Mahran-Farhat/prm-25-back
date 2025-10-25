package com.isikef.prm.controller;

import com.isikef.prm.dto.ProductDto;
import com.isikef.prm.entities.Product;
import com.isikef.prm.forms.ProductForm;
import com.isikef.prm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts(){
        List<Product> products = productService.getAllProducts();
        return ProductDto.of(products);
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductForm product) {
        Product p =  productService.saveProduct(product);
        return ProductDto.of(p);
    }

    @GetMapping(value = "/get")
    public ProductDto getProductById(@RequestParam Long id) {
        Product p = productService.getProductById(id);
        return ProductDto.of(p);
    }

    @GetMapping(value = "/getbypath/{id}")
    public ProductDto getProductByIdPath(@PathVariable(name = "id") Long id) {
        Product p =  productService.getProductById(id);
        return ProductDto.of(p);
    }

    @DeleteMapping
    public Map<String, Boolean> deleteProduct(@RequestParam Long id) {
        productService.deleteProduct(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }

    @PutMapping
    public ProductDto updateProduct(@RequestParam Long id, @RequestBody ProductForm product){
        Product p = productService.updateProduct(id,product);
        return ProductDto.of(p);
    }
}
