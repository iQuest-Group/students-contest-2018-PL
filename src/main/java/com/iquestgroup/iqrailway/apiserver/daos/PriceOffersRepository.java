package com.iquestgroup.iqrailway.apiserver.daos;

import com.iquestgroup.iqrailway.apiserver.model.PriceOffer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceOffersRepository extends JpaRepository<PriceOffer, Integer> {

  List<PriceOffer> findByOfferTrainId(Integer offerTrainId);

  List<PriceOffer> findByOfferTrainIdAndTravelClass(Integer offerTrainId, String travelClass);
}