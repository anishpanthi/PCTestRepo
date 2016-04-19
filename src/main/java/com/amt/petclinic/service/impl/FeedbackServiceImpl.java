package com.amt.petclinic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amt.petclinic.domain.Feedback;
import com.amt.petclinic.repository.FeedbackRepository;
import com.amt.petclinic.service.FeedbackService;

@Component
@Transactional
public class FeedbackServiceImpl implements FeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepo;

	@Override
	public void create(Feedback feedback) {
		feedbackRepo.save(feedback);
	}

	@Override
	public List<Feedback> findAll() {
		return feedbackRepo.findAll();
	}
}
