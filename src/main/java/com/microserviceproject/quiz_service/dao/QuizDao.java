package com.microserviceproject.quiz_service.dao;


import com.microserviceproject.quiz_service.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<Quiz,Integer> {
}
