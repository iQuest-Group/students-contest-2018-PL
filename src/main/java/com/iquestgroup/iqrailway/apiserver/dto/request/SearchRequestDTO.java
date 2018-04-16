package com.iquestgroup.iqrailway.apiserver.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SearchRequestDTO {

  @NotBlank
  private String origin;

  @NotBlank
  private String destination;

  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime departureDate;
}
