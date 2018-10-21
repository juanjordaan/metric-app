package com.juan.metric.service;

import java.util.ArrayList;
import java.util.List;

import static javax.measure.unit.NonSI.*;
import static javax.measure.unit.SI.*;
import static com.juan.metric.domain.model.Distance.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.juan.metric.domain.model.Distance;

@Service
public class DistanceService {
	private static final Logger LOG = LoggerFactory.getLogger(DistanceService.class);
	
	private static List<String> units = new ArrayList<>();
	
	static {
		units.add(_KILOMETRES);
		units.add(_MILES);
	}
	
	public Distance empty() {
		Distance distance = new Distance();
		
		distance.setUnits(units);
		
		return distance;
	}

	public Distance convert(Distance distance) {
		if(distance.getUnit().equalsIgnoreCase(_MILES)) {
			LOG.info("Converting Miles to Kilometres");
			distance.setValue(MILE.getConverterTo(KILOMETER).convert(distance.getValue()));
			distance.setUnit(_KILOMETRES);
		} else {
			LOG.info("Converting Kilometres to Miles");
			distance.setValue(KILOMETER.getConverterTo(MILE).convert(distance.getValue()));
			distance.setUnit(_MILES);
		}
		
		return distance;
	}
}
