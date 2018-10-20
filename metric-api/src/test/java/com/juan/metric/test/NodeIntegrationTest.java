package com.juan.metric.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.juan.metric.interfaces.node.rest.Node;

@RunWith(SpringRunner.class)
public class NodeIntegrationTest extends AbstractIntegrationTest<Node> {
	
	@Test
	public void test() {
		List<Node> nodes = new ArrayList<Node>();
		nodes.add(new Node(123, "NodeB", 7000 ));
		nodes.add(new Node(7000, "NodeA", 0 ));
		nodes.add(new Node(9, "NodeC", 123 ));
		
		nodes.add(new Node(3, "NodeF", 0));
		nodes.add(new Node(25, "NodeE", 7000));
		nodes.add(new Node(2, "NodeD", 7000));
		nodes.add(new Node(10, "NodeG", 3));
		
		nodes = postForNewInstance(nodes);
	}

	@Override
	protected String getRestPath() {
		return "/api/v1/nodes";
	}
	
	protected List<Node> postForNewInstance(List<Node> dto) {
		ResponseEntity<List<Node>> responseEntity = this.restTemplate.exchange(getRestPath(), HttpMethod.POST, new HttpEntity<>(dto, defaultHeaders), new ParameterizedTypeReference<List<Node>>(){});
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(responseEntity.getBody()).isNotNull();
		
		List<Node> response = responseEntity.getBody();
		
		return response;
	}
}
