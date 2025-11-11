package com.isikef.prm.controller;

import com.isikef.prm.dto.ProductDto;
import com.isikef.prm.entities.Product;
import com.isikef.prm.exceptions.MissingEntityException;
import com.isikef.prm.forms.PageParams;
import com.isikef.prm.forms.ProductForm;
import com.isikef.prm.forms.ProductSearchForm;
import com.isikef.prm.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
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

    public ResponseEntity processBindingResult(BindingResult bindingResult){
        Map<String,String> fieldsErrors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(
               error -> fieldsErrors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldsErrors);
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody ProductForm product, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return processBindingResult(bindingResult);
        Product p =  productService.saveProduct(product);
        return ResponseEntity.ok(ProductDto.of(p));
    }

    @GetMapping(value = "/get")
    public ProductDto getProductById(@RequestParam Long id) throws MissingEntityException {
        Product p = productService.getProductById(id);
        return ProductDto.of(p);
    }

    @GetMapping(value = "/getbypath/{id}")
    public ProductDto getProductByIdPath(@PathVariable(name = "id") Long id) throws MissingEntityException {
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
    public ResponseEntity updateProduct(@RequestParam Long id, @Valid @RequestBody ProductForm product,
                                    BindingResult bindingResult) throws MissingEntityException {
        if(bindingResult.hasErrors())
            return processBindingResult(bindingResult);
        Product p = productService.updateProduct(id,product);
        return ResponseEntity.ok(ProductDto.of(p));
    }

    @Operation(summary = "Search product", description = "Search product by category and name. "+
    "Product's category is mandatory. Product's name is optional. "+
    "The server will returns products matching indicated filters.")
    @GetMapping("/search")
    public ResponseEntity searchProduct(@ModelAttribute ProductSearchForm form){
        List<Product> products = productService.searchByCategoryAndName(form);
        return ResponseEntity.ok(ProductDto.of(products));

    }

    @GetMapping("/paginated")
    public ResponseEntity getPaginatedProduct(@ModelAttribute PageParams form){
        Page<Product> pProducts = productService.paginatedProducts(form);
        return ResponseEntity.ok(pProducts);
    }
}
