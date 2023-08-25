package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.auth.dto.LikeDto;
import com.grupo13.bookingdigital.auth.repository.UserRepository;
import com.grupo13.bookingdigital.exception.ParamNotFound;
import com.grupo13.bookingdigital.model.LikeEntity;
import com.grupo13.bookingdigital.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikeMap {
  private final UserRepository userRepository;
  private final ProductRepository productRepository;

  public List<LikeDto> likeEntityList2DtoList(List<LikeEntity> likes) {
    List<LikeDto> likesDto = new ArrayList<>();
    for (LikeEntity like : likes){
      likesDto.add(likeEntity2Dto(like));
    }
    return likesDto;
  }


  public LikeEntity likeDto2Entity(LikeDto likeDto) {
    LikeEntity entity = new LikeEntity();
    entity.setUser(userRepository.findByEmail(likeDto.getUserEmail())
        .orElseThrow(()-> new ParamNotFound("user not found")));
    entity.setProduct(productRepository.findById(likeDto.getProductId())
        .orElseThrow(()-> new ParamNotFound("product not found")));
    entity.setLiked(true);
    return entity;
  }

  private LikeDto likeEntity2Dto(LikeEntity entity) {
    LikeDto dto = new LikeDto();
    dto.setUserEmail(entity.getUser().getEmail());
    dto.setProductId(entity.getProduct().getId());
    dto.setLike(entity.getLiked());
    return dto;
  }
}
