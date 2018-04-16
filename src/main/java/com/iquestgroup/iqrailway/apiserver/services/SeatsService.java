package com.iquestgroup.iqrailway.apiserver.services;

import com.iquestgroup.iqrailway.apiserver.dto.AvailableSeatsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsAllocationDTO;

import java.util.List;

public interface SeatsService {

  AvailableSeatsDTO getAvailableSeats(Integer trainId, String travelClass);

  void updateSeats(Integer trainId, List<CarriageSeatsAllocationDTO> seatsAllocationDTOs);
}
