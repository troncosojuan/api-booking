package com.grupo13.bookingdigital.controller;

import com.grupo13.bookingdigital.dto.ProductDto;
import com.grupo13.bookingdigital.dto.RegisterProductResponse;
import com.grupo13.bookingdigital.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  public ProductServiceImpl productService;

  @PostMapping
  @CrossOrigin(origins = "http://localhost:5173")
  @PreAuthorize("ADMIN")
  public ResponseEntity<Long> save (@Valid @RequestBody ProductDto product){
    return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
  }

  @GetMapping
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<RegisterProductResponse> getAllProduct(){
    Long quantity = productService.quantity();
    List<ProductDto> products = productService.listAllProduct();
    RegisterProductResponse response = new RegisterProductResponse(quantity, products);

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/{id}")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
    ProductDto product = productService.searchById(id);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id){
    HttpStatus httpStatus = productService.delete(id);
    return ResponseEntity.status(httpStatus).build();
  }

}
