package com.grupo13.bookingdigital.service;


import com.grupo13.bookingdigital.dto.BookingDto;
import com.grupo13.bookingdigital.dto.BookingDtoBasic;
import java.util.List;

public interface IBookingService {

  Long save(BookingDto dto);

  List<BookingDtoBasic> ListAllBookingByIdProduct(Long id);

}
