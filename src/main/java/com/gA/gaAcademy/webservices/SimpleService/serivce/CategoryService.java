package com.gA.gaAcademy.webservices.SimpleService.serivce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;
import com.gA.gaAcademy.webservices.SimpleService.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	public Category findByName(String name) {
		return categoryRepository.findByName(name).get();
	}

//	public Category getCategoryByName(String uji) {
////		categoryRepository.findbyN
//	}
//	
	

}
