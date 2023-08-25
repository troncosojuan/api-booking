package com.grupo13.bookingdigital.service;

import com.grupo13.bookingdigital.auth.dto.LikeDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


public interface ILikesService {

  HttpStatus toggleLikeProduct(LikeDto likeDto);
}
