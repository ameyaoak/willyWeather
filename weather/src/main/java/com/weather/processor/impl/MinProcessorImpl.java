package com.weather.processor.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.weather.processor.Processor;

@Component
@ConditionalOnExpression("#{systemProperties['field']!=null && systemProperties['field'].equals('MIN')}")
public class MinProcessorImpl extends Processor {

	@Override
	public List<String> process() {
		List<String> valueList = new ArrayList<String>();
		for (String value : opFileParser.getColumnValuesForHeaderFromFile()) {
			valueList.add(value.replaceAll("\\*", ""));
		}
		return valueList;
	}

}