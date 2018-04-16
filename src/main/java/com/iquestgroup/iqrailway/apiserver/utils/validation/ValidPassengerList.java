package com.iquestgroup.iqrailway.apiserver.utils.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPassengerListValidator.class)
public @interface ValidPassengerList {

  String message() default "Invalid passengers list!";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
