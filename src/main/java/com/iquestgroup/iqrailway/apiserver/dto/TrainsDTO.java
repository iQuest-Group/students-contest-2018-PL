package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TrainsDTO {

  private String searchId;
  private List<TrainDTO> trains;
}
