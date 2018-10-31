package com.gA.gaAcademy.webservices.SimpleService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;
import com.gA.gaAcademy.webservices.SimpleService.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {


	List<Topic> findAllByCategories(Category cat);

}
