package com.gA.gaAcademy.webservices.SimpleService.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;
import com.gA.gaAcademy.webservices.SimpleService.entity.Topic;
import com.gA.gaAcademy.webservices.SimpleService.response.CategoryResponse;
import com.gA.gaAcademy.webservices.SimpleService.serivce.CategoryService;
import com.gA.gaAcademy.webservices.SimpleService.serivce.TopicService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	TopicService  topicService;
	
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategories (){
		
		List<CategoryResponse> response = new ArrayList<>(); 
		List<Category> lc = categoryService.findAll();
		lc.forEach(category -> response.add(new CategoryResponse(category)));
		return  new ResponseEntity<List<CategoryResponse>>(response,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/category/{name}")
	public ResponseEntity<?> getByCategory(@PathVariable String name){
		Category c = categoryService.findByName(name);
		List<Topic> lt = topicService.getByCategorie(c);
		return new ResponseEntity<List<Topic>>(lt,HttpStatus.OK);
	}

}
