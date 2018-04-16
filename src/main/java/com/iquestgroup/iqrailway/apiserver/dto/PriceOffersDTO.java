package com.iquestgroup.iqrailway.apiserver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PriceOffersDTO {

  private Integer trainId;
  private String travelClass;
  private List<PassengerDTO> passengers;
  private List<PriceOfferDTO> prices;
}
