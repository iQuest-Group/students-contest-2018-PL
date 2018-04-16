package com.iquestgroup.iqrailway.apiserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "FARERULES")
public class FareRule {

  @Id
  @Column(name = "ID")
  private String id;

  @Column(name = "RULE")
  private String rule;

  @Column(name = "PRICE_OFFER")
  private Integer priceOfferId;
}
