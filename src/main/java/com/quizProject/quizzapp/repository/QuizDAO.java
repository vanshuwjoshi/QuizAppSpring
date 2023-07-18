package com.quizProject.quizzapp.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quizProject.quizzapp.model.Quiz;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Integer>{
	
}
