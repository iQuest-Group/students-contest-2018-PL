package com.iquestgroup.iqrailway.apiserver.services;

import com.iquestgroup.iqrailway.apiserver.dto.TrainsDTO;

import java.time.LocalDateTime;

public interface SearchService {

  TrainsDTO searchTrains(String origin, String destination, LocalDateTime dateTime);
}