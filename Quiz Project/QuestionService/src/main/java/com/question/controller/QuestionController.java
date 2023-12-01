package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.model.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	// create
	@PostMapping
	public Question create(@RequestBody Question question) {
		return questionService.create(question);
	}

	// get all
	@GetMapping
	public List<Question> getAll() {
		return questionService.get();
	}

	@GetMapping("/{questionId}")
	public Question getAll(@PathVariable Long questionId) {
		return questionService.getOne(questionId);
	}

//  get all question of specific quiz
	@GetMapping("/quiz/{quizId}")
	public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
		return questionService.getQuestionsOfQuiz(quizId);
	}
}
