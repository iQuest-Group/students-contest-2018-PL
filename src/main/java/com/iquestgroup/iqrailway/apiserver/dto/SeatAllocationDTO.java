package com.iquestgroup.iqrailway.apiserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatAllocationDTO {

  @ApiModelProperty(value = "${swagger.properties.seats.seatId}")
  private Integer id;

  @ApiModelProperty(value = "${swagger.properties.seats.occupied}")
  private boolean occupied;
}
