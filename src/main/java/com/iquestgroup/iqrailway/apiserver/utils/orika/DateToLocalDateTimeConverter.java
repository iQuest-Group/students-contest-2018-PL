package com.iquestgroup.iqrailway.apiserver.utils.orika;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

public class DateToLocalDateTimeConverter extends BidirectionalConverter<Date, LocalDateTime> {

  @Override
  public LocalDateTime convertTo(Date date, Type<LocalDateTime> type) {
    return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
  }

  @Override
  public Date convertFrom(LocalDateTime localDateTime, Type<Date> type) {
    Instant asInstant = localDateTime.toInstant(OffsetDateTime.now().getOffset());
    return Date.from(asInstant);
  }
}
