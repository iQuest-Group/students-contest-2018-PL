package com.iquestgroup.iqrailway.apiserver.dto;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceOfferDTO {

  private Integer id;
  private String offerName;
  private String travelClass;
  private BigDecimal price;
  private String currency;
  private Set<FareRuleDTO> fareRules;
}
