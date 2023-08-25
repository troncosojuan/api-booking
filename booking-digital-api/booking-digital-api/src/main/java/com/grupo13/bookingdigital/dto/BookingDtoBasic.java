package com.grupo13.bookingdigital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import java.sql.Date;
import lombok.Data;

@Data
public class BookingDtoBasic {

  private Long id;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date initialDate;
  @NotNull
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date finalDate;
  private Long idProduct;

}
