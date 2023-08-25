package com.grupo13.bookingdigital.mapper;

import com.grupo13.bookingdigital.dto.PolicyDto;
import com.grupo13.bookingdigital.model.PolicyEntity;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class PolicyMap {

  public PolicyEntity policyDto2Entity(PolicyDto dto){
    PolicyEntity entity = new PolicyEntity();
    entity.setCheckIn(LocalTime.parse(dto.getCheckIn()));
    entity.setCheckOut(LocalTime.parse(dto.getCheckOut()));
    entity.setSmokeDetector(dto.getSmokeDetector());
    entity.setPartyAllowed(dto.getPartyAllowed());
    entity.setSmokingAllowed(dto.getSmokingAllowed());
    entity.setCovidRulesFollowed(dto.getCovidRulesFollowed());
    entity.setCancelation(dto.getCancelation());
    entity.setDeposit(dto.getDeposit());
    return entity;
  }

  public PolicyDto policyEntity2Dto(PolicyEntity entity){
    PolicyDto dto = new PolicyDto();
    dto.setId(entity.getId());
    dto.setCheckIn(entity.getCheckIn().format(DateTimeFormatter.ofPattern("HH:mm")));
    dto.setCheckOut(entity.getCheckOut().format(DateTimeFormatter.ofPattern("HH:mm")));
    dto.setSmokeDetector(entity.getSmokeDetector());
    dto.setPartyAllowed(entity.getPartyAllowed());
    dto.setSmokingAllowed(dto.getSmokingAllowed());
    dto.setCovidRulesFollowed(entity.getCovidRulesFollowed());
    dto.setCancelation(entity.getCancelation());
    dto.setDeposit(entity.getDeposit());
    return dto;
  }

}
