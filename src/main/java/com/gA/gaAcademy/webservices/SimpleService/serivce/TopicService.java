package com.gA.gaAcademy.webservices.SimpleService.serivce;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gA.gaAcademy.webservices.SimpleService.entity.Category;
import com.gA.gaAcademy.webservices.SimpleService.entity.Reply;
import com.gA.gaAcademy.webservices.SimpleService.entity.Topic;
import com.gA.gaAcademy.webservices.SimpleService.repository.CategoryRepository;
import com.gA.gaAcademy.webservices.SimpleService.repository.ReplyRepository;
import com.gA.gaAcademy.webservices.SimpleService.repository.TopicRepository;
import com.gA.gaAcademy.webservices.SimpleService.request.TopicRequest;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Autowired
	private CategoryRepository categoryRespository;

	public Topic getById(int id) throws NoSuchElementException {
		return topicRepository.findById(id).get();
	}

	public List<Topic> getAll() {
		return topicRepository.findAll();
	}

	public void createReply(Reply reply) {
		reply.setDate(new Date());
		replyRepository.save(reply);
	}

	public List<Reply> getReplies(int id) {
		return topicRepository.findById(id).get().getListOfReplies();
	}

	public List<Reply> getReplys(int id) throws NoSuchElementException {
		return replyRepository.findByTopic(topicRepository.findById(id).get()).get();
	}

	public void deleteTopic(int id) throws IllegalArgumentException, EmptyResultDataAccessException {
		topicRepository.deleteById(id);
	}

	public void deleteAllReplies(int id) {
		Topic t = topicRepository.findById(id).get();
		t.deleteListOfReplies();
		topicRepository.save(t);
	}

	public Topic updateByID(int id, Topic t) throws IllegalArgumentException, NoSuchElementException {
		Topic toUpdate = topicRepository.findById(id).get();
		if (t.getAuthor() > 0)
			toUpdate.setAuthor(t.getAuthor());
		if (t.getDatePost() != null)
			toUpdate.setDatePost(t.getDatePost());
		if (t.getDescription() != null)
			toUpdate.setDescription(t.getDescription());
		if (t.getTitle() != null)
			toUpdate.setTitle(t.getTitle());
		topicRepository.save(toUpdate);
		return toUpdate;
	}

	public Reply updateReplyByID(int id, Reply reply) throws NoSuchElementException {
		Reply toUpdate = replyRepository.findById(id).get();
		if (reply.getDescription() != null) {
			toUpdate.setDescription(reply.getDescription());
		}
		replyRepository.save(toUpdate);
		return toUpdate;
	}

	public Topic createTopic(TopicRequest topicRequest) {
		Topic response = new Topic(topicRequest);
		if (topicRequest.getCategories()!=null)
			response.setCategories(setCagoryByTopicRequest(topicRequest.getCategories()));
		topicRepository.save(response);
		return response;
	}

	private List<Category> setCagoryByTopicRequest(List<String> categories) {
		List<Category> response = new ArrayList<Category>();
		for (String category : categories) {
			Optional<Category> findByName = categoryRespository.findByName(category);
			if (findByName.isPresent())
				response.add(findByName.get());
			else
				response.add(new Category(category));
		}
		return response;

	}

	public List<Topic> getByCategorie(Category cat) {
		
		return topicRepository.findAllByCategories(cat);
	}

}
