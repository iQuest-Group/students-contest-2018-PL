package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarriageSeatsDTO {

  private Integer id;
  private String carriageNumber;
  private String travelClass;
  private Set<SeatDTO> availableSeats;
}
