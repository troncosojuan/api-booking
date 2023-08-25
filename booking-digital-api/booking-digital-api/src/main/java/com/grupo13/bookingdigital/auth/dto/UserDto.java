package com.grupo13.bookingdigital.auth.dto;

import com.grupo13.bookingdigital.dto.BookingDto;
import com.grupo13.bookingdigital.dto.BookingDtoBasic;
import com.grupo13.bookingdigital.dto.ProductDto;
import com.grupo13.bookingdigital.model.BookingEntity;
import java.util.List;
import lombok.Data;

@Data
public class UserDto {

  private String firstName;
  private String lastName;
  private String email;
  private String role;
  private List<BookingDtoBasic> bookings;
  private List<LikeDto> likes;
  private List<ProductDto> products;


}
