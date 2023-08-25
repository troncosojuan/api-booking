package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.dto.CharacteristicDto;
import com.grupo13.bookingdigital.model.CharacteristicEntity;
import org.springframework.stereotype.Component;

@Component
public class CharacteristicMap {

  public CharacteristicEntity characteristicDto2Entity(CharacteristicDto dto){
    CharacteristicEntity entity = new CharacteristicEntity();
    entity.setKitchen(dto.getKitchen());
    entity.setAirConditioning(dto.getAirConditioning());
    entity.setParking(dto.getParking());
    entity.setPetFriendly(dto.getPetFriendly());
    entity.setSwimmingPool(dto.getSwimmingPool());
    entity.setWifi(dto.getWifi());
    entity.setTv(dto.getTv());
    return entity;
  }


  public CharacteristicDto characteristicEntity2Dto(CharacteristicEntity entity) {
    CharacteristicDto dto = new CharacteristicDto();
    dto.setId(entity.getId());
    dto.setKitchen(entity.getKitchen());
    dto.setParking(entity.getParking());
    dto.setAirConditioning(entity.getAirConditioning());
    dto.setPetFriendly(entity.getPetFriendly());
    dto.setTv(entity.getTv());
    dto.setWifi(entity.getWifi());
    dto.setSwimmingPool(entity.getSwimmingPool());
    return dto;
  }
}
