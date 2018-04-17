package com.iquestgroup.iqrailway.apiserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO {

  @ApiModelProperty(value = "${swagger.properties.passenger.type}")
  private PassengerType passengerType;

  @ApiModelProperty(value = "${swagger.properties.passenger.amount}")
  private int amount;
}
