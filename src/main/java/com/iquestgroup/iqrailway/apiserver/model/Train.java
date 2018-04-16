package com.iquestgroup.iqrailway.apiserver.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "TRAINS")
public class Train {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "BUSINESS_ID")
  private String businessName;

  @Column(name = "ORIGIN")
  private String origin;

  @Column(name = "DESTINATION")
  private String destination;

  @Column(name = "DEPARTURE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date departure;

  @Column(name = "ARRIVAL")
  @Temporal(TemporalType.TIMESTAMP)
  private Date arrival;
}
