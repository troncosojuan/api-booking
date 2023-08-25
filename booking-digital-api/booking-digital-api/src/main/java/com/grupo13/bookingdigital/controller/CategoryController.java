package com.grupo13.bookingdigital.controller;


import com.grupo13.bookingdigital.dto.CategoryDto;
import com.grupo13.bookingdigital.dto.RegisterCategoryResponse;
import com.grupo13.bookingdigital.dto.RegisterProductResponse;
import com.grupo13.bookingdigital.model.CategoryEntity;
import com.grupo13.bookingdigital.service.impl.CategoryServiceImpl;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

  @Autowired
  public CategoryServiceImpl categoryService;

  @PostMapping
  @CrossOrigin(origins = "http://localhost:5173")
  @PreAuthorize("ADMIN")
  public ResponseEntity<Long> save (@Valid @RequestBody CategoryDto category) {
    return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createCategory(category));
  }

  @GetMapping
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<RegisterCategoryResponse> getAllCategories(){

    Long quantity = categoryService.quantity();
    List<CategoryDto> categories = categoryService.listAllCategory();


    RegisterCategoryResponse response = new RegisterCategoryResponse(quantity,
        categories);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/{id}")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto dto, @PathVariable("id") Long id ){
    CategoryDto categoryDto = categoryService.udpateCategory(dto, id);
    return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
  }

  @DeleteMapping("/{id}")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity deleteCategory (@PathVariable("id") Long id){
    categoryService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

}
