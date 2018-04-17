package com.iquestgroup.iqrailway.apiserver.dto;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainDTO {

  @ApiModelProperty(value = "${swagger.properties.train.id}")
  private Integer id;

  @ApiModelProperty(value = "${swagger.properties.seats.businessName}")
  private String businessName;

  @ApiModelProperty(value = "${swagger.properties.seats.origin}")
  private String origin;

  @ApiModelProperty(value = "${swagger.properties.seats.destination}")
  private String destination;

  @ApiModelProperty(value = "${swagger.properties.seats.departure}")
  private LocalDateTime departure;

  @ApiModelProperty(value = "${swagger.properties.seats.arrival}")
  private LocalDateTime arrival;
}
