package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarriageSeatsAllocationDTO {

  @ApiModelProperty(value = "${swagger.properties.seats.carriageId}")
  private Integer carriageId;

  @ApiModelProperty(value = "${swagger.properties.seats.seats}")
  private Set<SeatAllocationDTO> seats;
}
