package com.gA.gaAcademy.webservices.SimpleService.response;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;
import com.gA.gaAcademy.webservices.SimpleService.entity.Topic;

public class TopicResponse {

	
	private String title;
	
	private String description;
	
	private Date post_date;
	
	private int parent_id;
	
	private int author_id;
	
	private List<String> categories = new ArrayList<String>();

	public TopicResponse(String title, String description, Date post_date, int parent_id, int author_id) {
		super();
		this.title = title;
		this.description = description;
		this.post_date = post_date;
		this.parent_id = parent_id;
		this.author_id = author_id;
	}
	
	public TopicResponse(Topic topic) {
		super();
		this.title = topic.getTitle() +" " +topic.getId();
		this.description = topic.getDescription();
		this.post_date = topic.getDatePost();
		this.parent_id = 0;
		this.author_id = topic.getAuthor();
		this.categories = setCategories(topic);
	}
	
	private List<String> setCategories(Topic topic) {
		List<Category> lc = topic.getCategories();
		List<String> sc = new ArrayList<>();
		lc.forEach(ct -> sc.add(ct.getName()));
		return sc;
	}

	public TopicResponse () {}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	
	
	
	
	
}
