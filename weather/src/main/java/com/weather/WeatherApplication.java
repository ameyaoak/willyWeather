package com.weather;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.weather.service.HistoricalWeatherDataService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

	@Autowired
	private HistoricalWeatherDataService dataService;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		SpringApplication.run(WeatherApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		this.dataService.processFile();
	}
}
