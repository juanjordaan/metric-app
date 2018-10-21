package com.juan.metric.service;

import java.util.ArrayList;
import java.util.List;

import static com.juan.metric.domain.model.Temperature.*;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.juan.metric.domain.model.Temperature;

@Service
public class TemperatureService {
	private static final Logger LOG = LoggerFactory.getLogger(TemperatureService.class);
	
	private static List<String> units = new ArrayList<String>();
	
	static {
		units.add(_Fahrenheit);
		units.add(_Celsius);
	}
	
	public Temperature empty() {
		Temperature temperature = new Temperature();
		temperature.setUnits(units);
		
		return temperature;
	}

	public Temperature convert(Temperature temperature) {
		if(temperature.getUnit().equalsIgnoreCase(_Fahrenheit)) {
			LOG.info("Converting Fahrenheit to Celsius");
			temperature.setValue(FAHRENHEIT.getConverterTo(CELSIUS).convert(temperature.getValue()));
			temperature.setUnit(_Celsius);
		} else {
			LOG.info("Converting Celsius to Fahrenheit");
			temperature.setValue(CELSIUS.getConverterTo(FAHRENHEIT).convert(temperature.getValue()));
			temperature.setUnit(_Fahrenheit);
		}
		
		return temperature;
	}
}
