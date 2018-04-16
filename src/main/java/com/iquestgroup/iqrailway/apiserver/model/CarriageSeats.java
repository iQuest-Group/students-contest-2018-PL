package com.iquestgroup.iqrailway.apiserver.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity(name = "CARRIAGE_SEATS")
public class CarriageSeats {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "CARRIAGE_NUMBER")
  private String carriageNumber;

  @Column(name = "SEATS_TRAIN_ID")
  private Integer seatsTrainId;

  @Column(name = "TRAVEL_CLASS")
  private String travelClass;

  @OneToMany(mappedBy = "carriageId", targetEntity = Seat.class, fetch = FetchType.EAGER)
  private Set<Seat> availableSeats = new LinkedHashSet<>();
}
