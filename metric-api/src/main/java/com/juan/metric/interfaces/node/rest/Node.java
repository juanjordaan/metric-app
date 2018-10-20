package com.juan.metric.interfaces.node.rest;

import com.juan.metric.interfaces.rest.ApiDtoResponse;

public class Node implements ApiDtoResponse {
	private int id;
	private String label;
	private int parentId;
	
	protected Node() {
		
	}
	
	public Node(int id, String label, int parentId) {
		super();
		this.id = id;
		this.label = label;
		this.parentId = parentId;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return label + " (id: " + getId() + ", parentId: " + parentId + ")";
	}
}
