package com.iquestgroup.iqrailway.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({MapperConfig.class, SwaggerConfig.class})
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class);
  }
}
