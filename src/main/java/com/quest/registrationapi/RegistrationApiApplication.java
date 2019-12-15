package com.quest.registrationapi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

// By running this class, application will start running

@SpringBootApplication
@EnableCaching
public class RegistrationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationApiApplication.class, args);
	}

	
	//This method is used for ETags. 
	@Bean
	 public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
	  return new ShallowEtagHeaderFilter();
	 }

}
