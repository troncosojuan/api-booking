package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.dto.LocationDto;
import com.grupo13.bookingdigital.model.LocationEntity;
import org.springframework.stereotype.Component;

@Component
public class LocationMap {

  public LocationEntity locationDto2Entity(LocationDto dto){
    LocationEntity entity = new LocationEntity();
    entity.setCity(dto.getCity());
    entity.setCountry(dto.getCountry());
    entity.setUrl(dto.getUrl());
    entity.setReferencePoint(dto.getReferencePoint());
    entity.setMap(replaceDoubleQuotes(dto.getMap()));
    return entity;
  }

  private String replaceDoubleQuotes(String str) {
    return str.replaceAll("\"", "'");
  }

  public LocationDto locationEntity2Dto(LocationEntity entity) {
    LocationDto dto = new LocationDto();
    dto.setId(entity.getId());
    dto.setCity(entity.getCity());
    dto.setCountry(entity.getCountry());
    dto.setUrl(entity.getUrl());
    dto.setReferencePoint(entity.getReferencePoint());
    dto.setMap(entity.getMap());
    return dto;
  }
}
