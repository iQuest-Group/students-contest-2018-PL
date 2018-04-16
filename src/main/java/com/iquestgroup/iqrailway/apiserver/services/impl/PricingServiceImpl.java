package com.iquestgroup.iqrailway.apiserver.services.impl;

import com.iquestgroup.iqrailway.apiserver.daos.PriceOffersRepository;
import com.iquestgroup.iqrailway.apiserver.dto.PassengerDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PriceOfferDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PriceOffersDTO;
import com.iquestgroup.iqrailway.apiserver.model.PriceOffer;
import com.iquestgroup.iqrailway.apiserver.services.PricingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import ma.glasnost.orika.MapperFacade;

@Service
public class PricingServiceImpl implements PricingService {

  @Autowired
  private PriceOffersRepository priceOffersRepository;

  @Autowired
  private MapperFacade mapperFacade;


  @Override
  public PriceOffersDTO getPrices(Integer trainId, List<PassengerDTO> passengerList) {
    Objects.requireNonNull(trainId, "Train ID cannot be null!");
    Objects.requireNonNull(passengerList, "Passenger list cannot be null!");


    List<PriceOffer> priceOffers = priceOffersRepository.findByOfferTrainId(trainId);
    List<PriceOfferDTO> priceOfferDTOs = mapperFacade.mapAsList(priceOffers, PriceOfferDTO.class);
    return PriceOffersDTO.builder()
            .trainId(trainId)
            .passengers(passengerList)
            .prices(calculatePricesForAllPassengers(priceOfferDTOs, passengerList))
            .build();
  }

  @Override
  public PriceOffersDTO getPrices(Integer trainId, String travelClass, List<PassengerDTO> passengerList) {
    Objects.requireNonNull(trainId, "Train ID cannot be null!");
    Objects.requireNonNull(travelClass, "Travel class cannot be null!");
    Objects.requireNonNull(passengerList, "Passenger list cannot be null!");

    List<PriceOffer> priceOffers = priceOffersRepository.findByOfferTrainIdAndTravelClass(trainId, travelClass);
    List<PriceOfferDTO> priceOfferDTOs = mapperFacade.mapAsList(priceOffers, PriceOfferDTO.class);
    return PriceOffersDTO.builder()
            .trainId(trainId)
            .travelClass(travelClass)
            .passengers(passengerList)
            .prices(calculatePricesForAllPassengers(priceOfferDTOs, passengerList))
            .build();
  }

  protected List<PriceOfferDTO> calculatePricesForAllPassengers(List<PriceOfferDTO> priceOfferDTOs,
                                                                List<PassengerDTO> passengerList) {
    int totalNumberOfPassengers = passengerList.stream()
            .mapToInt(PassengerDTO::getAmount)
            .sum();

    priceOfferDTOs.forEach(po -> po.setPrice(po.getPrice().multiply(BigDecimal.valueOf(totalNumberOfPassengers))));
    return priceOfferDTOs;
  }
}
