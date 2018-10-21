package com.juan.metric.test;

import static com.juan.metric.domain.model.Weight.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.juan.metric.domain.model.Weight;

@RunWith(SpringRunner.class)
public class WeightIntegrationTest extends AbstractIntegrationTest<Weight> {
	
	@Test
	public void metricTest() {
		Weight weight = get();
		weight.setValue(new Double(10.0));
		weight.setUnit(_Kilogram);
		
		weight = post(weight);
		assertThat(weight.getUnit()).isEqualTo(_Pound);
		assertThat(weight.getValue()).isEqualTo(new Double(22.046226218487757));
	}
	
	@Test
	public void imperialTest() {
		Weight weight = get();
		weight.setValue(new Double(22.046226218487757));
		weight.setUnit(_Pound);
		
		weight = post(weight);
		assertThat(weight.getUnit()).isEqualTo(_Kilogram);
		assertThat(weight.getValue()).isEqualTo(new Double(9.999999999999998));
	}

	@Override
	protected String getRestPath() {
		return "/convert/weight";
	}
}
