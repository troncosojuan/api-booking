package com.grupo13.bookingdigital.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterCategoryResponse {
  private Long quantity;
  private List<CategoryDto> register;
}
