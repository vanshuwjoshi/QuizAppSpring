package com.quizProject.quizzapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizProject.quizzapp.model.Question;
import com.quizProject.quizzapp.repository.QuestionDAO;


@Service
public class QuestionService {

	@Autowired
	QuestionDAO questionDAO;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDAO.findAll(),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionByType(String type) {
		try {
			return new ResponseEntity<>(questionDAO.findByType(type),HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>() ,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		// TODO Auto-generated method stub
		questionDAO.save(question);
		return new ResponseEntity<>("added successfully",HttpStatus.CREATED);
	}

}

