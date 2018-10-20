package com.juan.metric.interfaces.node.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping(path="/api/v1/nodes")
@Controller
public class NodesController {
	@RequestMapping(
		produces = {APPLICATION_JSON_VALUE},
		consumes = {APPLICATION_JSON_VALUE},
		method=POST)
	@ResponseBody
	public ResponseEntity<List<Node>> createNodes(@RequestBody List<Node> nodes) {
		/*NodeAssembler nodeAssembler = new NodeAssembler();
		
		List<com.mm.test.domain.model.Node> entities = nodeAssembler.toEntity(nodes);
		entities = nodeService.create(entities);
		nodes = nodeAssembler.toDto(entities);*/
		
		ResponseEntity<List<Node>> response = new ResponseEntity<List<Node>>(new ArrayList<>(), CREATED);
		
		return response;
	}
}
