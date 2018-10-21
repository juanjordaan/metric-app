package com.juan.metric.test;

import static com.juan.metric.domain.model.Temperature.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.juan.metric.domain.model.Temperature;

@RunWith(SpringRunner.class)
public class TemperatureIntegrationTest extends AbstractIntegrationTest<Temperature> {
	
	@Test
	public void metricTest() {
		Temperature temperature = get();
		temperature.setValue(new Double(10.0));
		temperature.setUnit(_Celsius);
		
		temperature = post(temperature);
		assertThat(temperature.getUnit()).isEqualTo(_Fahrenheit);
		assertThat(temperature.getValue()).isEqualTo(new Double(49.99999999999994));
	}
	
	@Test
	public void imperialTest() {
		Temperature temperature = get();
		temperature.setValue(new Double(49.99999999999994));
		temperature.setUnit(_Fahrenheit);
		
		temperature = post(temperature);
		assertThat(temperature.getUnit()).isEqualTo(_Celsius);
		assertThat(temperature.getValue()).isEqualTo(new Double(10.0));
	}

	@Override
	protected String getRestPath() {
		return "/convert/temperature";
	}
}
