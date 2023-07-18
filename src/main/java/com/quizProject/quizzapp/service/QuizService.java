package com.quizProject.quizzapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quizProject.quizzapp.model.Question;
import com.quizProject.quizzapp.model.QuestionWrapper;
import com.quizProject.quizzapp.model.Quiz;
import com.quizProject.quizzapp.model.Response;
import com.quizProject.quizzapp.repository.QuestionDAO;
import com.quizProject.quizzapp.repository.QuizDAO;

@Service
public class QuizService {
	@Autowired
	QuizDAO quizDAO;

	@Autowired
	QuestionDAO questionDAO;
	
	public ResponseEntity<String> createQuiz(String type, int noOfQues, String title) {
		// TODO Auto-generated method stub
		
		List<Question> questions = questionDAO.findRandomQuestionsByCategory(type, noOfQues);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDAO.save(quiz);
		return new ResponseEntity<>("Successfully created quiz", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDAO.findById(id); //optional is used since we are not sure if id exists or not
		List<Question> questionsFromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUsers = new ArrayList<>();
		
		// we need to convert every question in questionsFromDB to questionwrapper (since we only want to display selected things)
		
		for(Question question : questionsFromDB) {
			QuestionWrapper questionWrapper = new QuestionWrapper(question.getId(), 
					question.getQuestion(), question.getOption1(), question.getOption2(), 
					question.getOption3(), question.getOption4());
			questionsForUsers.add(questionWrapper);
			
		}
		return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		// TODO Auto-generated method stub
		Optional<Quiz> quiz = quizDAO.findById(id);
		List<Question> questions = quiz.get().getQuestions();
		
		int correct = 0;
		int i = 0;
		
		for(Response response:responses) {
			if(response.getResponse().equals(questions.get(i).getCorrectOption())) {
				correct++;
			}
			i++;
		}
		
		return new ResponseEntity<>(correct,HttpStatus.OK);
	}
	
	
}
