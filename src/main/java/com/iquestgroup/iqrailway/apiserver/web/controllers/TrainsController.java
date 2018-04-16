package com.iquestgroup.iqrailway.apiserver.web.controllers;

import com.iquestgroup.iqrailway.apiserver.dto.AvailableSeatsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsAllocationDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PassengerDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PassengerType;
import com.iquestgroup.iqrailway.apiserver.dto.PriceOffersDTO;
import com.iquestgroup.iqrailway.apiserver.dto.TrainsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.request.PricesRequestDTO;
import com.iquestgroup.iqrailway.apiserver.dto.request.SearchRequestDTO;
import com.iquestgroup.iqrailway.apiserver.dto.request.SeatsRequestDTO;
import com.iquestgroup.iqrailway.apiserver.services.PricingService;
import com.iquestgroup.iqrailway.apiserver.services.SearchService;
import com.iquestgroup.iqrailway.apiserver.services.SeatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/trains")
public class TrainsController {

  @Autowired
  private SearchService searchService;

  @Autowired
  private PricingService pricingService;

  @Autowired
  private SeatsService seatsService;

  @RequestMapping(value = "/search", method = {RequestMethod.GET})
  public TrainsDTO search(@Valid SearchRequestDTO searchRequestDTO) {
    return searchService.searchTrains(searchRequestDTO.getOrigin(), searchRequestDTO.getDestination(),
            searchRequestDTO.getDepartureDate());
  }

  @RequestMapping(value = "/{trainId}/prices", method = {RequestMethod.GET})
  public PriceOffersDTO prices(@PathVariable("trainId") Integer trainId, @Valid PricesRequestDTO pricesRequestDTO) {
    return pricingService.getPrices(trainId, pricesRequestDTO.getTravelClass(), populateListOfPassengers(pricesRequestDTO));
  }

  @RequestMapping(value = "/{trainId}/seats", method = {RequestMethod.GET})
  public AvailableSeatsDTO seats(@PathVariable("trainId") Integer trainId, @RequestParam("travelClass") String travelClass) {
    return seatsService.getAvailableSeats(trainId, travelClass);
  }

  @RequestMapping(value = "/{trainId}/seats", method = {RequestMethod.PUT})
  public void changeSeatsStatus(@PathVariable("trainId") Integer trainId, @RequestBody @Valid SeatsRequestDTO request) {
    List<CarriageSeatsAllocationDTO> carriageSeats = request.getCarriageSeats();
    seatsService.updateSeats(trainId, carriageSeats);
  }

  protected List<PassengerDTO> populateListOfPassengers(PricesRequestDTO pricesRequestDTO) {
    LinkedList<PassengerDTO> passengerDTOs = new LinkedList<>();
    passengerDTOs.add(new PassengerDTO(PassengerType.ADULT, pricesRequestDTO.getNoOfAdults()));
    Integer noOfChildren = pricesRequestDTO.getNoOfChildren();
    passengerDTOs.add(new PassengerDTO(PassengerType.CHILD, noOfChildren != null ? noOfChildren : 0));
    Integer noOfStudents = pricesRequestDTO.getNoOfStudents();
    passengerDTOs.add(new PassengerDTO(PassengerType.STUDENT, noOfStudents != null ? noOfStudents : 0));
    return passengerDTOs;
  }
}
