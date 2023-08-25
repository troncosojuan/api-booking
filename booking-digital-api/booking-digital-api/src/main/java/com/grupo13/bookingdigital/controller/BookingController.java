package com.grupo13.bookingdigital.controller;

import com.grupo13.bookingdigital.dto.BookingDto;
import com.grupo13.bookingdigital.dto.BookingDtoBasic;
import com.grupo13.bookingdigital.dto.ProductDto;
import com.grupo13.bookingdigital.service.impl.BookingServiceImpl;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booking")
public class BookingController {

  @Autowired
  public BookingServiceImpl bookingService;

  @PostMapping
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<Long> save (@Valid @RequestBody BookingDto booking){
    return ResponseEntity.status(HttpStatus.CREATED).body(bookingService.save(booking));
  }

  @GetMapping("/{id}/products")
  @CrossOrigin(origins = "http://localhost:5173")
  public ResponseEntity<List<BookingDtoBasic>> getAllBookingsByIdProduct(@PathVariable Long id){
    List<BookingDtoBasic> bookingList = bookingService.ListAllBookingByIdProduct(id);
    return ResponseEntity.status(HttpStatus.OK).body(bookingList);
  }

}
