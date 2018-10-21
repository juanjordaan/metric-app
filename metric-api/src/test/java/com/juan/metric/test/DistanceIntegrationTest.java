package com.juan.metric.test;

import static com.juan.metric.domain.model.Distance.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.juan.metric.domain.model.Distance;

@RunWith(SpringRunner.class)
public class DistanceIntegrationTest extends AbstractIntegrationTest<Distance> {
	
	@Test
	public void metricTest() {
		Distance distance = get();
		distance.setValue(new Double(10.0));
		distance.setUnit(_KILOMETRES);
		
		distance = post(distance);
		assertThat(distance.getUnit()).isEqualTo(_MILES);
		assertThat(distance.getValue()).isEqualTo(new Double(6.2137119223733395));
	}
	
	@Test
	public void imperialTest() {
		Distance distance = get();
		distance.setValue(new Double(6.2137119223733395));
		distance.setUnit(_MILES);
		
		distance = post(distance);
		assertThat(distance.getUnit()).isEqualTo(_KILOMETRES);
		assertThat(distance.getValue()).isEqualTo(new Double(10.0));
	}

	@Override
	protected String getRestPath() {
		return "/convert/distance";
	}
}
