package com.iquestgroup.iqrailway.apiserver.daos;

import com.iquestgroup.iqrailway.apiserver.model.CarriageSeats;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarriageSeatsRepository extends JpaRepository<CarriageSeats, Integer> {

  List<CarriageSeats> findBySeatsTrainId(Integer seatsTrainId);

  List<CarriageSeats> findBySeatsTrainIdAndTravelClass(Integer seatsTrainId, String travelClass);
}