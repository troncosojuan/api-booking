package com.grupo13.bookingdigital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class BookingDto {

  private Long id;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date initialDate;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date finalDate;

  private String username;

  private Long productId;


}
