package com.quizProject.quizzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quizProject.quizzapp.model.QuestionWrapper;
import com.quizProject.quizzapp.model.Response;
import com.quizProject.quizzapp.service.QuizService;

// want to create something like post request: 
// http://localhost:8080/quiz/create?type=Java&noOfQues=5&title=JavaQuiz
// this will create a java quiz with with 5 question

// http://localhost:8080/quiz/get/2 this will get us the quiz questions that can be shown to user

// http://localhost:8080/quiz/submit/2 will submit the quiz with id 2 along with responses to question

@RestController
@RequestMapping(path = "quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping(path = "create")
	public ResponseEntity<String> createQuiz(@RequestParam String type, 
			@RequestParam int noOfQues, 
			@RequestParam String title){
		return quizService.createQuiz(type,noOfQues,title);
	}
	
	@GetMapping(path = "get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestion(id);
	}
	
	@PostMapping(path = "submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses);
	}
}
