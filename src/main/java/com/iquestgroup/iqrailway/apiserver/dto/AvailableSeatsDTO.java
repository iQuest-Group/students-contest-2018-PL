package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvailableSeatsDTO {

  private List<CarriageSeatsDTO> carriages;
}
