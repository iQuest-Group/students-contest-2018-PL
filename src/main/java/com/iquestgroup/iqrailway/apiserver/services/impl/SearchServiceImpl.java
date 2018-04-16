package com.iquestgroup.iqrailway.apiserver.services.impl;

import com.iquestgroup.iqrailway.apiserver.daos.TrainsRepository;
import com.iquestgroup.iqrailway.apiserver.dto.TrainDTO;
import com.iquestgroup.iqrailway.apiserver.dto.TrainsDTO;
import com.iquestgroup.iqrailway.apiserver.model.Train;
import com.iquestgroup.iqrailway.apiserver.services.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import ma.glasnost.orika.MapperFacade;

@Service
public class SearchServiceImpl implements SearchService {

  @Autowired
  TrainsRepository trainsRepository;

  @Autowired
  private MapperFacade mapperFacade;

  @Override
  public TrainsDTO searchTrains(String origin, String destination, LocalDateTime departureDate) {
    Objects.requireNonNull(origin, "Origin cannot be null!");
    Objects.requireNonNull(destination, "Destination cannot be null!");
    Objects.requireNonNull(departureDate, "Departure date cannot be null!");

    Instant asInstant = departureDate.toInstant(OffsetDateTime.now().getOffset());
    Date departure = Date.from(asInstant);
    List<Train> results = trainsRepository.findByOriginAndDestinationAndDate(origin, destination, departure);

    return TrainsDTO.builder()
            .trains(mapperFacade.mapAsList(results, TrainDTO.class))
            .searchId(UUID.randomUUID().toString())
            .build();
  }
}