package com.iquestgroup.iqrailway.apiserver.dto;

import java.math.BigDecimal;
import java.util.Set;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceOfferDTO {

  @ApiModelProperty(value = "${swagger.properties.priceoffer.id}")
  private Integer id;

  @ApiModelProperty(value = "${swagger.properties.priceoffer.name}")
  private String offerName;

  @ApiModelProperty(value = "${swagger.properties.priceoffer.travelClass}")
  private String travelClass;

  @ApiModelProperty(value = "${swagger.properties.priceoffer.price}")
  private BigDecimal price;

  @ApiModelProperty(value = "${swagger.properties.priceoffer.currency}")
  private String currency;

  @ApiModelProperty(value = "${swagger.properties.priceoffer.farerules}")
  private Set<FareRuleDTO> fareRules;
}
