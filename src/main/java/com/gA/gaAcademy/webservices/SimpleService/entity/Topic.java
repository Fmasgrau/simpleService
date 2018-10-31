package com.gA.gaAcademy.webservices.SimpleService.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.gA.gaAcademy.webservices.SimpleService.request.TopicRequest;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "date")
	private Date datePost;
	
	@Column(name = "author")
	private int author;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "topic",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Reply> listOfReplies = new ArrayList<Reply>();
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Category> categories = new ArrayList<Category>();
	
	@Column(name = "description")
	private String description;
	
	public Topic() {}

	

	public Topic(String title, Date datePost, int author, List<Reply> listOfReplies, List<Category> categories,
			String description) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.author = author;
		this.listOfReplies = listOfReplies;
		this.categories = categories;
		this.description = description;
	}
	
	public Topic(TopicRequest tr) {
		super();
		this.title = tr.getTitle();
		this.datePost = tr.getDatePost();
		this.author = tr.getAuthor();
		this.listOfReplies = tr.getListOfReplies();
		this.description = tr.getDescription();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public List<Reply> getListOfReplies() {
		return listOfReplies;
	}

	public void setListOfReplies(List<Reply> listOfReplies) {
		this.listOfReplies = listOfReplies;
	}


	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public void deleteListOfReplies() {
		this.listOfReplies.clear();
		
	}
	


}
