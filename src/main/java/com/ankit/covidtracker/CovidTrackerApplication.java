package com.ankit.covidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling  //means it knows that Scheduled needs to be run
public class CovidTrackerApplication {

	public static void main(String[] args) {

		SpringApplication.run(CovidTrackerApplication.class, args);
	}

}
