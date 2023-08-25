package com.grupo13.bookingdigital.service;

import com.grupo13.bookingdigital.dto.ProductDto;
import java.util.List;
import org.springframework.http.HttpStatus;

public interface IProductService {

  List<ProductDto> listAllProduct();

  Long saveProduct (ProductDto dto);

  ProductDto searchById (Long id);

  Long quantity();

  HttpStatus delete(Long id);

}
