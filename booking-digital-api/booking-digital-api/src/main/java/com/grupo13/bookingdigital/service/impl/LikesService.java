package com.grupo13.bookingdigital.service.impl;

import com.grupo13.bookingdigital.auth.dto.LikeDto;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.mapper.LikeMap;
import com.grupo13.bookingdigital.model.LikeEntity;
import com.grupo13.bookingdigital.repository.LikeRepository;
import com.grupo13.bookingdigital.repository.ProductRepository;
import com.grupo13.bookingdigital.service.ILikesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class LikesService implements ILikesService {

  @Autowired
  private LikeRepository likeRepository;
  @Autowired
  private LikeMap likeMap;

  @Override
  public HttpStatus toggleLikeProduct(LikeDto likeDto) {
    List<LikeEntity> likes = likeRepository.findAll();
    Optional<LikeEntity> aLike = likes.stream()
        .filter(like -> like.getUser().getUsername().equals(likeDto.getUserEmail()) && like.getProduct().getId().equals(likeDto.getProductId())).findFirst();

    if (aLike.isPresent()) {
      LikeEntity likePresent = aLike.get();
      likePresent.setLiked(!likePresent.getLiked());
      likeRepository.save(likePresent);
    }else {
      likeRepository.save(likeMap.likeDto2Entity(likeDto));
    }
    return HttpStatus.OK;
  }
}
