package com.grupo13.bookingdigital.dto;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class ProductDto {

  private Long id;
  @NotNull
  private String name;
  @NotNull
  private String descriptionCard;
  @NotNull
  private String descriptionPage;
  @NotNull
  private Integer price;
  private Integer score;


  @NotNull
  private Long categoryId;
  @NotNull
  private PolicyDto policy;
  @NotNull
  private CharacteristicDto characteristic;

  @NotNull
  private LocationDto location;
  @NotNull
  private ImageDto image;
  private List<BookingDtoBasic> bookings;
  private String userEmail;

}
