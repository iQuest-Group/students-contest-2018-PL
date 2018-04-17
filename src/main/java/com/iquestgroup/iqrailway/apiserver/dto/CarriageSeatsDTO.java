package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarriageSeatsDTO {

  @ApiModelProperty(value = "${swagger.properties.carriageseat.id}")
  private Integer id;

  @ApiModelProperty(value = "${swagger.properties.carriageseat.carid}")
  private String carriageNumber;

  @ApiModelProperty(value = "${swagger.properties.carriageseat.travelclass}")
  private String travelClass;

  @ApiModelProperty(value = "${swagger.properties.carriageseat.availableSeats}")
  private Set<SeatDTO> availableSeats;
}
