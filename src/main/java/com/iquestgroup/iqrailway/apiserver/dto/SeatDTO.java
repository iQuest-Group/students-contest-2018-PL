package com.iquestgroup.iqrailway.apiserver.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeatDTO {

  @ApiModelProperty(value = "${swagger.properties.seatdto.id}")
  private Integer id;

  @ApiModelProperty(value = "${swagger.properties.seatdto.name}")
  private String name;

  @ApiModelProperty(value = "${swagger.properties.seatdto.available}")
  private boolean available;
}
