package com.grupo13.bookingdigital.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalTime;
import lombok.Data;

@Data
public class PolicyDto {

  private Long id;
  @NotNull
  private String checkIn;
  @NotNull
  private String checkOut;
  @NotNull
  private Boolean smokingAllowed;
  @NotNull
  private Boolean partyAllowed;
  @NotNull
  private Boolean smokeDetector;
  @NotNull
  private Boolean covidRulesFollowed;
  @NotNull
  private Boolean deposit;
  @NotNull
  private Boolean cancelation;

}
