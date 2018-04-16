package com.iquestgroup.iqrailway.apiserver.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {

  private Integer id;
  private String businessName;
  private String origin;
  private String destination;
  private LocalDateTime departure;
  private LocalDateTime arrival;
}
