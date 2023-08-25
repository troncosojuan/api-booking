package com.grupo13.bookingdigital.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo13.bookingdigital.auth.model.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "booking")
public class BookingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "initial_date")
  private Date initialDate;

  @JsonFormat(pattern = "yyyy-MM-dd")
  @Column(name = "final_date")
  private Date finalDate;

  @ManyToOne
  @JoinColumn(name = "users_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private ProductEntity product;
}
