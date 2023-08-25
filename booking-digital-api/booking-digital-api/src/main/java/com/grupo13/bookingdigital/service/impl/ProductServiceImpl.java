package com.grupo13.bookingdigital.service.impl;

import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.dto.ProductDto;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.mapper.ProductMap;
import com.grupo13.bookingdigital.model.CategoryEntity;
import com.grupo13.bookingdigital.model.ProductEntity;

import com.grupo13.bookingdigital.repository.CategoryRepository;
import com.grupo13.bookingdigital.repository.ProductRepository;
import com.grupo13.bookingdigital.service.IProductService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private ProductMap productMap;
  @Autowired
  private CategoryRepository categoryRepository;


  @Override
  public List<ProductDto> listAllProduct() {
    List<ProductDto> productDtoList = new ArrayList<>();
    for (ProductEntity entity : productRepository.findAll()){
      if (!entity.isDeleted()) {
        ProductDto productDto = productMap.productEntity2Dto(entity);
        productDtoList.add(productDto);
      }
    }
    return productDtoList;
  }

  @Override
  public Long saveProduct(ProductDto dto) {
    ProductEntity productEntity = productMap.productDto2Entity(dto);
    ProductEntity productSaved = productRepository.save(productEntity);
    Long productID = productSaved.getId();
    CategoryEntity category = categoryRepository.findById(dto.getCategoryId()).get();
    category.getProducts().add(productSaved);
    return productID;
  }


  @Override
  public ProductDto searchById(Long id) {
    ProductEntity product = productRepository.findById(id).orElseThrow(() -> new ParamNotFound("Product not found"));
    if (product.isDeleted()) {
      throw new ParamNotFound("Product has been deleted");
    }
    ProductDto dto = productMap.productEntity2Dto(product);
    return dto;
  }

  @Override
  public Long quantity() {
    return productRepository.countByDeletedFalse();
  }



  @Override
  public HttpStatus delete(Long id) {
    ProductEntity entity = productRepository.findById(id).orElseThrow(()-> new ParamNotFound("Product not found"));
    entity.setDeleted(true);
    productRepository.save(entity);
    return HttpStatus.NO_CONTENT;

  }
}
