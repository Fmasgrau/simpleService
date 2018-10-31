
package com.gA.gaAcademy.webservices.SimpleService.request;

import java.util.Date;
import java.util.List;

import com.gA.gaAcademy.webservices.SimpleService.entity.Reply;

public class TopicRequest {

	private String title;
	
	private int author;
	
	private String description;
	
	private List<String> categories;
	
	private Date datePost;
	
	private List<Reply> listOfReplies;

	public TopicRequest(String title, int author, String description, List<String> categories, Date datePost,
			List<Reply> listOfReplies) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.categories = categories;
		this.datePost = datePost;
		this.listOfReplies = listOfReplies;
	}
	
	
	public TopicRequest () {}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getAuthor() {
		return author;
	}


	public void setAuthor(int author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<String> getCategories() {
		return categories;
	}


	public void setCategories(List<String> categories) {
		this.categories = categories;
	}


	public Date getDatePost() {
		return datePost;
	}


	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}


	public List<Reply> getListOfReplies() {
		return listOfReplies;
	}


	public void setListOfReplies(List<Reply> listOfReplies) {
		this.listOfReplies = listOfReplies;
	}
	
	
	

}
