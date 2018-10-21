package com.juan.metric.domain.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Measure {
	private Double value;
	private String unit;
	private List<String> units = new ArrayList<String>();
	
	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public List<String> getUnits() {
		return units;
	}

	public void setUnits(List<String> units) {
		this.units = units;
	}
}
