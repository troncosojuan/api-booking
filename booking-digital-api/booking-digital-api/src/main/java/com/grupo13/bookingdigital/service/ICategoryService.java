package com.grupo13.bookingdigital.service;

import com.grupo13.bookingdigital.dto.CategoryDto;
import java.util.List;
import org.springframework.http.HttpStatus;

public interface ICategoryService {

  List<CategoryDto> listAllCategory();

  Long createCategory (CategoryDto dto);

  Long quantity ();

  CategoryDto udpateCategory (CategoryDto dto, Long id);

  HttpStatus delete (Long id);


}
