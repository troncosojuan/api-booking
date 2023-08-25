package com.grupo13.bookingdigital.service.impl;

import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.dto.BookingDto;
import com.grupo13.bookingdigital.dto.BookingDtoBasic;
import com.grupo13.bookingdigital.mapper.BookingMap;
import com.grupo13.bookingdigital.model.BookingEntity;
import com.grupo13.bookingdigital.repository.BookingRepository;
import com.grupo13.bookingdigital.repository.ProductRepository;
import com.grupo13.bookingdigital.service.IBookingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements IBookingService {

  @Autowired
  private BookingRepository bookingRepository;
  @Autowired
  private BookingMap bookingMap;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Long save(BookingDto dto) {
    BookingEntity bookingEntity = bookingMap.bookingDTO2Entity(dto);
    BookingEntity entitySaved = bookingRepository.save(bookingEntity);
    userRepository.findByEmail(dto.getUsername()).get().getBookings().add(entitySaved);
    productRepository.findById(dto.getProductId()).get().getBookings().add(entitySaved);
    return entitySaved.getId();
  }

  @Override
  public List<BookingDtoBasic> ListAllBookingByIdProduct(Long id) {
    List<BookingEntity> bookings = bookingRepository.findAllByProductId(id);
    List<BookingDtoBasic> bookingDtos = bookingMap.bookingListEntity2DtoList(bookings);
    return bookingDtos;
  }

}

