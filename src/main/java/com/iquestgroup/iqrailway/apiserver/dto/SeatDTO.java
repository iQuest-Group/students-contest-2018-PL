package com.iquestgroup.iqrailway.apiserver.dto;

import lombok.Data;

@Data
public class SeatDTO {

  private Integer id;
  private String name;
  private boolean available;
}
