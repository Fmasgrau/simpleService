package com.gA.gaAcademy.webservices.SimpleService.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gA.gaAcademy.webservices.SimpleService.entity.Reply;
import com.gA.gaAcademy.webservices.SimpleService.entity.Topic;
import com.gA.gaAcademy.webservices.SimpleService.request.TopicRequest;
import com.gA.gaAcademy.webservices.SimpleService.response.ReplyResponse;
import com.gA.gaAcademy.webservices.SimpleService.response.TopicResponse;
import com.gA.gaAcademy.webservices.SimpleService.serivce.TopicService;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@PostMapping("/topic")
	public ResponseEntity<?> createTopic(@RequestBody TopicRequest topicRequest) {
		Topic topicCreate = topicService.createTopic(topicRequest);
		 return new ResponseEntity<TopicResponse>(new TopicResponse(topicCreate),HttpStatus.ACCEPTED);
	}
	
	@PostMapping ("/topic/{id}/reply")
	public ResponseEntity<ReplyResponse> createReply(@RequestBody Reply reply, @PathVariable int id) {
		Topic t1 = topicService.getById(id);
		reply.setTopic(t1);
		topicService.createReply(reply);
		return new ResponseEntity<ReplyResponse>(new ReplyResponse(reply),HttpStatus.ACCEPTED);
	}
	
	@GetMapping ("/topic")
	public List<TopicResponse> getAllTopic(){
		List<TopicResponse> responses = new ArrayList<TopicResponse>();
		List <Topic> topics = topicService.getAll();
		topics.forEach(topic -> responses.add(new TopicResponse(topic)) );
		return responses;
	}
	
	@GetMapping ("/topic/{id}")
	public ResponseEntity<TopicResponse> getById(@PathVariable int id) {
		try {
			TopicResponse topicResponse = new TopicResponse(topicService.getById(id));
			return new ResponseEntity<TopicResponse>(topicResponse,HttpStatus.ACCEPTED);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<TopicResponse>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/topic/{id}/reply")
	public ResponseEntity<?> getAllReply(@PathVariable int id) {
		List<ReplyResponse> responses = new ArrayList<>();
		List<Reply> replies;
		try {
			replies = topicService.getReplies(id);
			replies.forEach(reply -> responses.add(new ReplyResponse(reply)));
			return ResponseEntity.ok(replies);
		} catch (NoSuchElementException e) {		
			e.printStackTrace();
			return (ResponseEntity<?>) ResponseEntity.notFound();
		}		
	}
	
	@DeleteMapping("/topic/{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable int id) {
		
		try {
			topicService.deleteTopic(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/topic/{id}/reply")
	public ResponseEntity<?> deleteAll(@PathVariable int id) {		
		try {
			topicService.deleteAllReplies(id);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/topic/{id}")
	public ResponseEntity<?> updateTopic(@RequestBody Topic topic, @PathVariable int id) {
		try {
			Topic response = topicService.updateByID(id,topic);
			return new ResponseEntity<TopicResponse>(new TopicResponse(response),HttpStatus.ACCEPTED);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("The Id not exist",HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/topic/{id}/reply/{idReply}")
	public ResponseEntity<?> updateReply(@RequestBody Reply reply, @PathVariable int idReply) {
		try {
			Reply response = topicService.updateReplyByID(idReply,reply);
			return new ResponseEntity<ReplyResponse>(new ReplyResponse(response),HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

}
