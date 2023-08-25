package com.grupo13.bookingdigital.auth.mapper;

import com.grupo13.bookingdigital.auth.dto.UserDto;
import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.mapper.BookingMap;
import com.grupo13.bookingdigital.mapper.LikeMap;
import com.grupo13.bookingdigital.mapper.ProductMap;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMap {

  @Autowired
  private BookingMap bookingMap;
  @Autowired
  private LikeMap likeMap;
  @Autowired
  private ProductMap productMap;


  public UserDto userEntity2Dto(UserEntity entity) {
    UserDto dto = new UserDto();
    dto.setFirstName(entity.getFirstname());
    dto.setLastName(entity.getLastname());
    dto.setEmail(entity.getUsername());
    dto.setRole(String.valueOf(entity.getRole()));
    dto.setBookings(bookingMap.bookingListEntity2DtoList(entity.getBookings()));
    dto.setLikes(likeMap.likeEntityList2DtoList(entity.getLikes()));
    dto.setProducts(productMap.productEntityList2DtoList(entity.getProducts()));
    return dto;
  }
}
