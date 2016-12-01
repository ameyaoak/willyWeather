package com.weather.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface HistoricalWeatherDataService {
	public void processFile() throws FileNotFoundException, IOException;
}