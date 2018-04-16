package com.iquestgroup.iqrailway.apiserver.dto.request;

import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsAllocationDTO;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class SeatsRequestDTO {

  @NotNull
  private List<CarriageSeatsAllocationDTO> carriageSeats;
}
