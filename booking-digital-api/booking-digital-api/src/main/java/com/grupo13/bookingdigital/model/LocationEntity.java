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
@Table(name = "location")
public class LocationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;

  @Column (name = "country")
  private String country;

  @Column (name = "city")
  private String city;

  @Column (name = "reference_point")
  private String referencePoint;

  @Column (name = "url")
  private String url;

  @Column (name = "map")
  private String map;

}
