package com.weather.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeatherData {
	private String STN;
	private String WBAN;
	private String YEARMODA;
	private String TEMP;
	private String DEWP;
	private String SLP;
	private String STP;
	private String VISIB;
	private String WDSP;
	private String MXSPD;
	private String GUST;
	private String MAX;
	private String MIN;
	private String PRCP;
	private String SNDP;
	private String FRSHTT;
}
