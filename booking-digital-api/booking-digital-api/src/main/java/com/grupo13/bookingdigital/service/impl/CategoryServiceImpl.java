package com.grupo13.bookingdigital.service.impl;

import com.grupo13.bookingdigital.dto.CategoryDto;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.mapper.CategoryMap;
import com.grupo13.bookingdigital.model.CategoryEntity;
import com.grupo13.bookingdigital.repository.CategoryRepository;
import com.grupo13.bookingdigital.service.ICategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements ICategoryService {

  @Autowired
  private CategoryRepository categoryRepository;
  @Autowired
  private CategoryMap categoryMap;

  @Override
  public List<CategoryDto> listAllCategory() {
    List<CategoryEntity> entity = categoryRepository.findAll();
    List<CategoryDto> dtoList = categoryMap.categoryEntityList2DTOList(entity);
    return dtoList;
  }

  @Override
  public Long createCategory(CategoryDto dto) {
    CategoryEntity entity = categoryMap.categoryDTO2Entity(dto);
    CategoryEntity entitySaved = categoryRepository.save(entity);
    Long categoryId = entitySaved.getId();
    return categoryId;
  }

  @Override
  public Long quantity() {
    return categoryRepository.countByDeletedFalse();
  }

  @Override
  public CategoryDto udpateCategory(CategoryDto dto, Long id) {
    CategoryEntity categoryEntity = categoryMap.categoryUpdateDTO2Entity(dto, id);
    CategoryEntity categoryUpdate = categoryRepository.save(categoryEntity);
    CategoryDto categoryDto = categoryMap.categoryEntity2DTO(categoryUpdate);
    return categoryDto;
  }



  @Override
  public HttpStatus delete(Long id) {
    CategoryEntity entity = categoryRepository.findById(id).orElseThrow(()-> new ParamNotFound("Category not found"));
    entity.setDeleted(true);
    categoryRepository.save(entity);
    return HttpStatus.NO_CONTENT;
  }
}
