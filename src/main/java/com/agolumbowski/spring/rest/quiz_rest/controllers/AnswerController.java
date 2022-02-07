/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.service.AnswerService;
import com.agolumbowski.spring.rest.quiz_rest.service.QuestionService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agolu
 */
@RestController
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping("/quizes/{quizId}/questions/{questionId}/answers")
    public List<Answer> getAnswers(@PathVariable Long quizId,
            @PathVariable Long questionId) {

        return questionService.read(questionId).getAnswers();
    }

    @PostMapping("/quizes/{quizId}/questions/{questionId}/answers")
    public Answer createAnswer(@RequestBody Answer answer) {

        return answerService.save(answer);
    }

    @PutMapping("/quizes/{quizId}/questions/{questionId}/answers")
    public Answer editAnswer(@RequestBody Answer answer) {

        return answerService.save(answer);
    }

    @DeleteMapping("/quizes/{quizId}/questions/{questionId}/answers/{answerId}")
    public String deleteAnswer(@PathVariable Long answerId) {

        answerService.delete(answerId);
        return "answer was deleted";
    }

    @GetMapping("/quizes/{quizId}/questions/{questionId}/answers/{answerId}")
    public Answer getAnswer(@PathVariable Long quizId,
            @PathVariable Long answerId) {

        return answerService.read(answerId);
    }

}
