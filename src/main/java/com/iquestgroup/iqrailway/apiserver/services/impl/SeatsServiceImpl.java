package com.iquestgroup.iqrailway.apiserver.services.impl;

import com.iquestgroup.iqrailway.apiserver.daos.CarriageSeatsRepository;
import com.iquestgroup.iqrailway.apiserver.daos.SeatsRepository;
import com.iquestgroup.iqrailway.apiserver.dto.AvailableSeatsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsAllocationDTO;
import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.SeatAllocationDTO;
import com.iquestgroup.iqrailway.apiserver.model.CarriageSeats;
import com.iquestgroup.iqrailway.apiserver.model.Seat;
import com.iquestgroup.iqrailway.apiserver.services.SeatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import ma.glasnost.orika.MapperFacade;

@Service
public class SeatsServiceImpl implements SeatsService {

  @Autowired
  private CarriageSeatsRepository carriageSeatsRepository;

  @Autowired
  private SeatsRepository seatsRepository;

  @Autowired
  private MapperFacade mapperFacade;

  @Override
  public AvailableSeatsDTO getAvailableSeats(Integer trainId, String travelClass) {
    List<CarriageSeats> availableSeats = carriageSeatsRepository.findBySeatsTrainIdAndTravelClass(trainId, travelClass);
    List<CarriageSeatsDTO> carriageSeatsDTOs = mapperFacade.mapAsList(availableSeats, CarriageSeatsDTO.class);

    return AvailableSeatsDTO.builder()
            .carriages(carriageSeatsDTOs)
            .build();
  }

  @Override
  @Transactional
  public void updateSeats(Integer trainId, List<CarriageSeatsAllocationDTO> seatsAllocationDTOs) {
    List<Seat> seatsToUpdate = new LinkedList<>();
    for (CarriageSeatsAllocationDTO item : seatsAllocationDTOs) {
      Integer carId = item.getCarriageId();
      Set<SeatAllocationDTO> seats = item.getSeats();
      for (SeatAllocationDTO seatDTO : seats) {
        Seat seat = seatsRepository.findByIdAndCarriageId(seatDTO.getId(), carId);
        seatsToUpdate.add(seat);
        seat.setAvailable(!seatDTO.isOccupied());
      }
    }
    seatsRepository.saveAll(seatsToUpdate);
  }
}
