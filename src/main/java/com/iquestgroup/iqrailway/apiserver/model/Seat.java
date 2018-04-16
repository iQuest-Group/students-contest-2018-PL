package com.iquestgroup.iqrailway.apiserver.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "SEATS")
public class Seat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CARRIAGE_ID")
  private Integer carriageId;

  @Column(name = "AVAILABLE")
  private boolean available;
}
