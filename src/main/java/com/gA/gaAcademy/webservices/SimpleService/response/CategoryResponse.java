package com.gA.gaAcademy.webservices.SimpleService.response;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;

public class CategoryResponse {
	
	private int id;
	
	private String name;

	public CategoryResponse(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public CategoryResponse(Category category) {
		super();
		this.id = category.getId();
		this.name = category.getName();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
