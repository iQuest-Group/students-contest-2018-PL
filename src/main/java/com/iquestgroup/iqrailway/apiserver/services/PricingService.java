package com.iquestgroup.iqrailway.apiserver.services;

import com.iquestgroup.iqrailway.apiserver.dto.PassengerDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PriceOffersDTO;

import java.util.List;

public interface PricingService {

  PriceOffersDTO getPrices(Integer trainId, List<PassengerDTO> passengerList);

  PriceOffersDTO getPrices(Integer trainId, String travelClass, List<PassengerDTO> passengerList);
}
