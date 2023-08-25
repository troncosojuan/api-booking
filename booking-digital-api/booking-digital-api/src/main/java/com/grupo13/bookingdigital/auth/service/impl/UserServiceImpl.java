package com.grupo13.bookingdigital.auth.service.impl;

import com.grupo13.bookingdigital.auth.dto.LikeDto;
import com.grupo13.bookingdigital.auth.dto.UserDto;
import com.grupo13.bookingdigital.auth.mapper.UserMap;
import com.grupo13.bookingdigital.auth.model.UserEntity;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.auth.service.IUserService;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.mapper.LikeMap;
import com.grupo13.bookingdigital.model.LikeEntity;
import com.grupo13.bookingdigital.model.ProductEntity;
import com.grupo13.bookingdigital.repository.ProductRepository;
import com.grupo13.bookingdigital.service.impl.LikesService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

  private final UserRepository userRepository;
  private final UserMap userMap;
  private final LikesService likesService;





  @Override
  public UserDto getUserByEmail(String userEmail) {
    UserEntity user = userRepository.findByEmail(userEmail).get();
    return userMap.userEntity2Dto(user);
  }

  @Override
  public HttpStatus likeProduct(LikeDto likeDto) {
    return likesService.toggleLikeProduct(likeDto);
  }

}

