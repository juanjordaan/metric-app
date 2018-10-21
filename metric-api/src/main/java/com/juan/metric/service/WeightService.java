package com.juan.metric.service;

import java.util.ArrayList;
import java.util.List;

import static com.juan.metric.domain.model.Weight.*;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.juan.metric.domain.model.Weight;

@Service
public class WeightService {
	private static final Logger LOG = LoggerFactory.getLogger(WeightService.class);
	
	private static List<String> units = new ArrayList<>();
	
	static {
		units.add(_Kilogram);
		units.add(_Pound);
	}
	
	public Weight empty() {
		Weight weight = new Weight();
		weight.setUnits(units);
		weight.setUnit(_Kilogram);
		weight.setValue(new Double(0));
		
		return weight;
	}
	
	public Weight convert(Weight weight) {
		if(weight.getUnit().equalsIgnoreCase(_Pound)) {
			LOG.info("Converting Pound to Kilogram");
			weight.setValue(POUND.getConverterTo(KILOGRAM).convert(weight.getValue()));
			weight.setUnit(_Kilogram);
		} else {
			LOG.info("Converting Kilogram to Pound");
			weight.setValue(KILOGRAM.getConverterTo(POUND).convert(weight.getValue()));
			weight.setUnit(_Pound);
		}
		
		return weight;
	}
}
