package com.iquestgroup.iqrailway.apiserver.daos;

import com.iquestgroup.iqrailway.apiserver.model.Seat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatsRepository extends JpaRepository<Seat, Integer> {

  Seat findByIdAndCarriageId(Integer id, Integer carriageId);
}