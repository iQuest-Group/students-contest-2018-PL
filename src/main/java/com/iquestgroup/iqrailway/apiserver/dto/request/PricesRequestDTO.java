package com.iquestgroup.iqrailway.apiserver.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PricesRequestDTO {

  @NotBlank
  @ApiModelProperty(value = "${swagger.properties.prices.travelClass}")
  private String travelClass;

  @NotNull
  @Min(1)
  @ApiModelProperty(value = "${swagger.properties.prices.noOfAdults}")
  private Integer noOfAdults;

  @Min(0)
  @ApiModelProperty(value = "${swagger.properties.prices.noOfChildren}")
  private Integer noOfChildren;

  @Min(0)
  @ApiModelProperty(value = "${swagger.properties.prices.noOfStudents}")
  private Integer noOfStudents;
}
