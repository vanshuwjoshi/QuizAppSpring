package com.quizProject.quizzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizProject.quizzapp.model.Question;
import com.quizProject.quizzapp.service.QuestionService;


@RestController
@RequestMapping(path = "question")
public class QuestionController {

	@Autowired //injects the object dependency, no need to create object of service.
	QuestionService questionService;
	
	@GetMapping(path = "allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping(path = "type/{type}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String type) {
		return questionService.getQuestionByType(type);
	}
	
	@PostMapping(path = "add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	//create delete and update mapping
}
