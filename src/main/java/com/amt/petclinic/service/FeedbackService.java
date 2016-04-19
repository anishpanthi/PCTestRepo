package com.amt.petclinic.service;

import java.util.List;

import com.amt.petclinic.domain.Feedback;

public interface FeedbackService {

	public void create(Feedback feedback);

//	public void delete(int id);

	public List<Feedback> findAll();

//	public void update(Feedback feedback);

//	public Feedback findById(int id);

}
