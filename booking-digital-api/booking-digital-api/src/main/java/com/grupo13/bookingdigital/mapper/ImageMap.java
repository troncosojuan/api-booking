package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.dto.ImageDto;
import com.grupo13.bookingdigital.model.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ImageMap {

  public ImageEntity imageDto2Entity (ImageDto dto){
    ImageEntity entity = new ImageEntity();
    entity.setUrl(dto.getUrl());
    return entity;
  }

  public ImageDto imageEntity2Dto(ImageEntity entity) {
    ImageDto dto = new ImageDto();
    dto.setId(entity.getId());
    dto.setUrl(entity.getUrl());
    return dto;
  }
}
