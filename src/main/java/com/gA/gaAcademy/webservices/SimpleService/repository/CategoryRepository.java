package com.gA.gaAcademy.webservices.SimpleService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
	boolean existsByName(String name);
	
	Optional<Category> findByName(String name);
}
