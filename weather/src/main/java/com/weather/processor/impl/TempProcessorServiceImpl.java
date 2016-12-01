package com.weather.processor.impl;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import com.weather.processor.Processor;

@Component
@ConditionalOnExpression("#{systemProperties['field']!=null && systemProperties['field'].equals('TEMP')}")
public class TempProcessorServiceImpl extends Processor {

	@Override
	public List<String> process() {
		return opFileParser.getColumnValuesForHeaderFromFile();
	}

}
