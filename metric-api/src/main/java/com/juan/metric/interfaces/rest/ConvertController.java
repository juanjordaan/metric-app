package com.juan.metric.interfaces.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.juan.metric.domain.model.Distance;
import com.juan.metric.domain.model.Temperature;
import com.juan.metric.domain.model.Weight;
import com.juan.metric.service.DistanceService;
import com.juan.metric.service.TemperatureService;
import com.juan.metric.service.WeightService;

@RequestMapping(path="/convert")
@Controller
public class ConvertController {
	@Autowired
	private DistanceService distanceService;
	
	@Autowired
	private TemperatureService temperatureService;
	
	@Autowired
	private WeightService weightService;
	
	@RequestMapping(path="/distance", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=GET)
	@ResponseBody
	public ResponseEntity<Distance> distanceGet() {

		Distance distance = distanceService.empty();
		
		return new ResponseEntity<Distance>(distance, OK);
	}
	
	@RequestMapping(path="/distance", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=POST)
	@ResponseBody
	public ResponseEntity<Distance> distancePost(@RequestBody Distance distance) {

		distance = distanceService.convert(distance);
		
		return new ResponseEntity<Distance>(distance, OK);
	}
	
	@RequestMapping(path="/temperature", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=GET)
	@ResponseBody
	public ResponseEntity<Temperature> temperatureGet() {
		
		Temperature temperature = temperatureService.empty();
		
		return new ResponseEntity<Temperature>(temperature, OK);
	}
	
	@RequestMapping(path="/temperature", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=POST)
	@ResponseBody
	public ResponseEntity<Temperature> temperaturePost(@RequestBody Temperature temperature) {
		
		temperature = temperatureService.convert(temperature);
		
		return new ResponseEntity<Temperature>(temperature, OK);
	}
	
	@RequestMapping(path="/weight", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=GET)
	@ResponseBody
	public ResponseEntity<Weight> weightGet() {
		
		Weight weight = weightService.empty();
		
		return new ResponseEntity<Weight>(weight, OK);
	}
	
	@RequestMapping(path="/weight", 
			produces = APPLICATION_JSON_VALUE, 
			consumes = APPLICATION_JSON_VALUE, 
			method=POST)
	@ResponseBody
	public ResponseEntity<Weight> weightPost(@RequestBody Weight weight) {
		
		weight = weightService.convert(weight);
		
		return new ResponseEntity<Weight>(weight, OK);
	}
}
