package com.grupo13.bookingdigital.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocationDto {

  private Long id;
  @NotNull
  private String country;
  @NotNull
  private String city;
  @NotNull
  private String url;
  @NotNull
  private String map;
  @NotNull
  private String referencePoint;

}
