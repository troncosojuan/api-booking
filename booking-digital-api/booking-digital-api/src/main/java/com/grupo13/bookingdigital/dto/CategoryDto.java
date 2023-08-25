package com.grupo13.bookingdigital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryDto {

  private Long id;
  @NotNull
  private String description;
  @NotNull
  private String title;
  @NotNull
  private String urlImage;

  private Integer products;

}
