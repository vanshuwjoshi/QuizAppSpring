package com.quizProject.quizzapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.quizProject.quizzapp.model.Question;


@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer>{

	List<Question> findByType(String type);

	@Query(value = "SELECT * FROM questions q WHERE q.type=:type ORDER BY RAND() LIMIT :noOfQues", nativeQuery = true)
	List<Question> findRandomQuestionsByCategory(String type, int noOfQues);

}
