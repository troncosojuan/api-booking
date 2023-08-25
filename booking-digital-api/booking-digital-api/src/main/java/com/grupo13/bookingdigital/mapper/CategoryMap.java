package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.dto.CategoryDto;
import com.grupo13.bookingdigital.model.CategoryEntity;
import com.grupo13.bookingdigital.repository.CategoryRepository;
import com.grupo13.bookingdigital.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class CategoryMap {

  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private ProductRepository productRepository;

  public CategoryEntity categoryDTO2Entity(CategoryDto dto){
    CategoryEntity entity = new CategoryEntity();
    entity.setTitle(dto.getTitle());
    entity.setDescription(dto.getDescription());
    entity.setUrlImage(dto.getUrlImage());
    return entity;
  }

  public CategoryDto categoryEntity2DTO(CategoryEntity entity){
    CategoryDto dto = new CategoryDto();
    dto.setId(entity.getId());
    dto.setTitle(entity.getTitle());
    dto.setDescription(entity.getDescription());
    dto.setUrlImage(entity.getUrlImage());
    Integer count = productRepository.countByCategoryIdAndDeletedFalse(entity.getId());
    dto.setProducts(count);
    return dto;
  }

  public List<CategoryDto> categoryEntityList2DTOList(List<CategoryEntity> entities){
    List<CategoryDto> categoryDtoList = new ArrayList<>();
    for (CategoryEntity entity : entities){
      if (!entity.isDeleted()) {
        categoryDtoList.add(categoryEntity2DTO(entity));
      }
    }
    return categoryDtoList;
  }

  public CategoryEntity categoryUpdateDTO2Entity(CategoryDto dto, Long id) {
    CategoryEntity entity = categoryRepository.findById(id).get();
    entity.setTitle(dto.getTitle());
    entity.setDescription(dto.getDescription());
    entity.setUrlImage(dto.getUrlImage());
    return entity;
  }
}
