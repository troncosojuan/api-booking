package com.grupo13.bookingdigital.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class LikeDto {

  private String userEmail;
  private Long productId;
  private Boolean like;


}
