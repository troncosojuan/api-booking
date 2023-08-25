package com.grupo13.bookingdigital.auth.service;

import com.grupo13.bookingdigital.auth.dto.LikeDto;
import com.grupo13.bookingdigital.auth.dto.UserDto;
import org.springframework.http.HttpStatus;

public interface IUserService {

  UserDto getUserByEmail (String email);

    HttpStatus likeProduct(LikeDto likeDto);
}
