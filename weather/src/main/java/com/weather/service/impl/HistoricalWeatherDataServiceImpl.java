package com.weather.service.impl;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weather.processor.Processor;
import com.weather.service.HistoricalWeatherDataService;

@Component
public class HistoricalWeatherDataServiceImpl implements HistoricalWeatherDataService {

	@Autowired(required = false)
	private Processor processor;

	/**
	 * Processes file and returns results
	 */
	public void processFile() throws FileNotFoundException, IOException {
		if (processor != null) {
			processor.roundUp();
		}
	}

}
