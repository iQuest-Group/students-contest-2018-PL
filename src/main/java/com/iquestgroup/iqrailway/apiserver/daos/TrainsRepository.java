package com.iquestgroup.iqrailway.apiserver.daos;

import com.iquestgroup.iqrailway.apiserver.model.Train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TrainsRepository extends JpaRepository<Train, Integer> {

  List<Train> findByOriginAndDestination(String origin, String destination);

  @Query("SELECT t FROM TRAINS t WHERE t.origin=?1 AND t.destination=?2 AND t.departure>=?3")
  List<Train> findByOriginAndDestinationAndDate(String origin, String destination, Date departureDate);

}