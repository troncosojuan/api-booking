package com.grupo13.bookingdigital.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "characteristic")
public class CharacteristicEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column (name = "kitchen")
  private Boolean kitchen;
  @Column (name = "tv")
  private Boolean tv;
  @Column (name = "airConditioning")
  private Boolean airConditioning;
  @Column (name = "petFriendly")
  private Boolean petFriendly;
  @Column (name = "parking")
  private Boolean parking;
  @Column (name = "swimmingPool")
  private Boolean swimmingPool;
  @Column (name = "wifi")
  private Boolean wifi;

}
