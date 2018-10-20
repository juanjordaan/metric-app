package com.juan.metric.interfaces.rest;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

public class Assembler<E extends Object, O extends ApiDtoResponse> {
	protected final Class<E> entityClass;
	protected final Class<O> dtoClass;
	
	protected ModelMapper mapper = new ModelMapper();
	
	@SuppressWarnings("unchecked")
	protected Assembler() {
		this.entityClass = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.dtoClass = (Class<O>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	public O toDto(E entity) {
		if(entity == null) {
			return null;
		}
		
		return mapper.map(entity, dtoClass);
	}
	
	public E toEntity(O dto) {
		if(dto == null) {
			return null;
		}
		
		return mapper.map(dto, entityClass);
	}
	
	public List<E> toEntity(List<O> dtos) {
		if(dtos == null) return null;
		
		return dtos.stream().map(this::toEntity).collect(Collectors.toList());
	}
	
	public List<O> toDto(List<E> entities) {
		if(entities == null) return null;
		
		return entities.stream().map(this::toDto).collect(Collectors.toList());
	}
}
