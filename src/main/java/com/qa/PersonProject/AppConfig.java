package com.qa.PersonProject;

// create instance of model mapper
// bean that spring should be controlling
// by adding this config class

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Bean that Spring should be controlling
    @Bean
    public ModelMapper mapper(){
        return new ModelMapper(); // Create an instance of a Model Mapper
    };

}
