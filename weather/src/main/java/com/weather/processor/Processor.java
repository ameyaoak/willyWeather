package com.weather.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.weather.fileParser.OpFileParser;

public abstract class Processor {

	@Autowired
	public OpFileParser opFileParser;

	public abstract List<String> process();

	public List<Long> roundUp() {
		List<String> valueList = process();
		List<Long> valueListDouble = new ArrayList<Long>();
		if (valueList != null) {
			for (String value : valueList) {
				valueListDouble.add(Math.round(Double.parseDouble(value)));
			}
		}
		return valueListDouble;

	}
}
