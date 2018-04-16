package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarriageSeatsAllocationDTO {

  private Integer carriageId;
  private Set<SeatAllocationDTO> seats;
}
