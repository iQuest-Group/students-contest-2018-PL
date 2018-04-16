package com.iquestgroup.iqrailway.apiserver.model;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "PRICEOFFERS")
public class PriceOffer {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "OFFER_NAME")
  private String offerName;

  @Column(name = "TRAVEL_CLASS")
  private String travelClass;

  @Column(name = "PRICE")
  private BigDecimal price;

  @Column(name = "CURRENCY")
  private String currency;

  @Column(name = "OFFER_TRAIN_ID")
  private Integer offerTrainId;

  @OneToMany(mappedBy = "priceOfferId", targetEntity = FareRule.class, fetch = FetchType.EAGER)
  private Set<FareRule> fareRules = new LinkedHashSet<>();
}
