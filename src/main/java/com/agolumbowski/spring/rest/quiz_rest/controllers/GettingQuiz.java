/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.entity.User;
import com.agolumbowski.spring.rest.quiz_rest.entity.UserQuizResult;
import com.agolumbowski.spring.rest.quiz_rest.service.QuizService;
import java.util.List;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agolu
 */
@RestController
public class GettingQuiz {

    private final QuizService quizService;

    public GettingQuiz(QuizService quizService) {

        this.quizService = quizService;
    }

    @GetMapping("/start/{quizId}")
    public String startQuiz(@PathVariable Long quizId) {

        quizService.startQuiz();
        return "redirect:/quizzing/" + quizId;
    }

    @GetMapping("/quizzing/{quizId}")
    public Question getCurrentQuestion(@PathVariable Long quizId) {
        return quizService.getCurrentQuestion(quizId);
    }

    @PostMapping("/quizzing/{quizId}")
    public String quizCheckUserAnswers(@RequestBody Question questionWithUserAnswers,
            @AuthenticationPrincipal User user,
            @PathVariable Long quizId) {

        return quizService.quizCheckUserAnswers(questionWithUserAnswers, user, quizId);
    }

    @GetMapping("/results")
    public List<UserQuizResult> getUserResults(@AuthenticationPrincipal User user) {

        return user.getUserQuizResults();
    }
}
