package com.iquestgroup.iqrailway.apiserver;

import com.iquestgroup.iqrailway.apiserver.dto.CarriageSeatsDTO;
import com.iquestgroup.iqrailway.apiserver.dto.FareRuleDTO;
import com.iquestgroup.iqrailway.apiserver.dto.PriceOfferDTO;
import com.iquestgroup.iqrailway.apiserver.dto.TrainDTO;
import com.iquestgroup.iqrailway.apiserver.model.CarriageSeats;
import com.iquestgroup.iqrailway.apiserver.model.FareRule;
import com.iquestgroup.iqrailway.apiserver.model.PriceOffer;
import com.iquestgroup.iqrailway.apiserver.model.Train;
import com.iquestgroup.iqrailway.apiserver.utils.orika.DateToLocalDateTimeConverter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class MapperConfig {

  @Bean
  public DateToLocalDateTimeConverter dateToLocalDateTimeConverter() {
    return new DateToLocalDateTimeConverter();
  }

  @Bean
  public MapperFactory mapperFactory() {
    DefaultMapperFactory.Builder builder = new DefaultMapperFactory.Builder();
    DefaultMapperFactory mapperFactory = builder.build();

    mapperFactory.classMap(PriceOffer.class, PriceOfferDTO.class)
            .exclude("offerTrainId")
            .byDefault()
            .register();

    mapperFactory.classMap(FareRule.class, FareRuleDTO.class)
            .exclude("priceOfferId")
            .byDefault()
            .register();

    mapperFactory.classMap(Train.class, TrainDTO.class)
            .byDefault()
            .register();

    mapperFactory.classMap(CarriageSeats.class, CarriageSeatsDTO.class)
            .exclude("seatsTrainId")
            .byDefault()
            .register();

    ConverterFactory converterFactory = mapperFactory.getConverterFactory();
    converterFactory.registerConverter(dateToLocalDateTimeConverter());

    return mapperFactory;
  }

  @Bean
  public MapperFacade mapperFacade() {
    return mapperFactory().getMapperFacade();
  }
}
