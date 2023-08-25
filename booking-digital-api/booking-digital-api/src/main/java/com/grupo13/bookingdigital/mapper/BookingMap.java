package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.dto.BookingDto;
import com.grupo13.bookingdigital.dto.BookingDtoBasic;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.model.BookingEntity;
import com.grupo13.bookingdigital.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMap {

  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private UserRepository userRepository;

  public BookingEntity bookingDTO2Entity(BookingDto dto) {
    BookingEntity entity = new BookingEntity();
    entity.setInitialDate(dto.getInitialDate());
    entity.setFinalDate(dto.getFinalDate());
    entity.setProduct(productRepository.findById(dto.getProductId()).orElseThrow(() -> new ParamNotFound("product not found")));
    entity.setUser(userRepository.findByEmail(dto.getUsername()).orElseThrow(()-> new ParamNotFound("user not found")));
    return entity;
  }

  public BookingDtoBasic bookingEntity2DtoBasic(BookingEntity entity){
    BookingDtoBasic dto = new BookingDtoBasic();
    dto.setId(entity.getId());
    dto.setInitialDate(entity.getInitialDate());
    dto.setFinalDate(entity.getFinalDate());
    dto.setIdProduct(entity.getProduct().getId());
    return dto;
  }

  public List<BookingDtoBasic> bookingListEntity2DtoList(List<BookingEntity> bookings) {
    List<BookingDtoBasic> bookingDtos = new ArrayList<>();
    for (BookingEntity booking : bookings){
      bookingDtos.add(bookingEntity2DtoBasic(booking));
    }
    return bookingDtos;
  }
}
