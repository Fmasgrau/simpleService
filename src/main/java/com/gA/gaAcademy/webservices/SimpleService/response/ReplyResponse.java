package com.gA.gaAcademy.webservices.SimpleService.response;

import java.util.Date;

import com.gA.gaAcademy.webservices.SimpleService.entity.Reply;

public class ReplyResponse {
	
	private String title;
	
	private String description;
	
	private Date reply_date;
	
	private int parent_id;
	
	private int author_id;

	public ReplyResponse(String title, String description, Date reply_date, int parent_id, int author_id) {
		super();
		this.title = title;
		this.description = description;
		this.reply_date = reply_date;
		this.parent_id = parent_id;
		this.author_id = author_id;
	}
	
	public ReplyResponse(Reply reply) {
		super();
		this.title = null;
		this.description = reply.getDescription();
		this.reply_date = reply.getDate();
		this.parent_id = reply.getTopic().getId();
		this.author_id = reply.getAuthor();
		}
	
	public ReplyResponse() {}

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

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
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
	
	
	
	

	

}
