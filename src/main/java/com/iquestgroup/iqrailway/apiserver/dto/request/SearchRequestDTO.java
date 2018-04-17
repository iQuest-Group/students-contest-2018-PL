package com.iquestgroup.iqrailway.apiserver.dto.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SearchRequestDTO {

  @NotBlank
  @ApiModelProperty(value = "${swagger.properties.search.origin}")
  private String origin;

  @NotBlank
  @ApiModelProperty(value = "${swagger.properties.search.destination}")
  private String destination;

  @NotNull
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  @ApiModelProperty(value = "${swagger.properties.search.departureDate}")
  private LocalDateTime departureDate;
}
