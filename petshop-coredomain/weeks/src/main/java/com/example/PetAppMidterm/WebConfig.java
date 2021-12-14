package com.example.PetAppMidterm;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  //8081 port와 연결
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/pets")
        .allowedOrigins("http://localhost:8081");
  }
}