package com.amt.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amt.petclinic.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer>{

}
