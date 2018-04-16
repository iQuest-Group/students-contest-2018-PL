package com.iquestgroup.iqrailway.apiserver.utils.validation;

import com.iquestgroup.iqrailway.apiserver.dto.PassengerDTO;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ValidPassengerListValidator implements ConstraintValidator<ValidPassengerList, List<PassengerDTO>> {

  @Override
  public boolean isValid(List<PassengerDTO> passengerList, ConstraintValidatorContext constraintValidatorContext) {
    if(CollectionUtils.isEmpty(passengerList)) {
      return false;
    }

    int totalNumberOfPassenger = passengerList.stream()
            .mapToInt(PassengerDTO::getAmount)
            .sum();
    return totalNumberOfPassenger > 0;
  }
}
