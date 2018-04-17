package com.iquestgroup.iqrailway.apiserver.dto.request;

import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsAllocationDTO;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SeatsRequestDTO {

  @NotNull
  @ApiModelProperty(value = "${swagger.properties.seats.carriageSeats}")
  private List<CarriageSeatsAllocationDTO> carriageSeats;
}
