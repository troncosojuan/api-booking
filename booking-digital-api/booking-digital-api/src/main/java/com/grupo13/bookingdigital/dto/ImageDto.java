package com.grupo13.bookingdigital.dto;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
public class ImageDto {

  private Long id;
  private Set<String> url;

}
