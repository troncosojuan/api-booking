package com.grupo13.bookingdigital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "policy")
public class PolicyEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "check_in")
  private LocalTime checkIn;

  @Column(name = "check_out")
  private LocalTime checkOut;

  @Column(name = "smoking_allowed")
  private Boolean smokingAllowed;

  @Column(name = "party_allowed")
  private Boolean partyAllowed;

  @Column(name = "smoke_detector")
  private Boolean smokeDetector;

  @Column(name = "covid_rules_followed")
  private Boolean covidRulesFollowed;

  @Column(name = "deposit")
  private Boolean deposit;

  @Column(name = "cancelation")
  private Boolean cancelation;

}
