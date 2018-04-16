package com.iquestgroup.iqrailway.apiserver.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PricesRequestDTO {

  @NotBlank
  private String travelClass;

  @NotNull
  @Min(1)
  private Integer noOfAdults;

  @Min(0)
  private Integer noOfChildren;

  @Min(0)
  private Integer noOfStudents;
}
