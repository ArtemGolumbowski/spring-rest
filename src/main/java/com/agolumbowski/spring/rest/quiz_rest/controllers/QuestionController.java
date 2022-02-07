
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agolu
 */
@RestController
//@RequestMapping("/admin")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/quizes/{quizId}/questions")
    public Page getQuestionsPage(@PathVariable Long quizId,
            @RequestParam(defaultValue = "0") int currentPage,
            @RequestParam(defaultValue = "2") int countPerPage,
            @RequestParam Long filterBySubject,
            @RequestParam(defaultValue = "id") String sort) {

        return questionService.getAll(currentPage, countPerPage, sort, quizId);

    }

    @GetMapping("/quizes/{quizId}/questions/{questionId}")
    public Question getQuestion(@PathVariable Long questionId) {

        return questionService.read(questionId);

    }

    @PostMapping("/quizes/{quizId}/questions")
    public Question createQuestion(@RequestBody Question question) {

        return questionService.save(question);

    }

    @PutMapping("/quizes/{quizId}/questions")
    public Question editQuestion(@RequestBody Question question) {

        return questionService.save(question);

    }

}
