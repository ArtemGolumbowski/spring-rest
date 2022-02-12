package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import com.agolumbowski.spring.rest.quiz_rest.service.QuizService;
import com.agolumbowski.spring.rest.quiz_rest.service.SubjectService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class QuizController {

    public QuizController(QuizService quizService, SubjectService subjectService) {
        this.quizService = quizService;
        this.subjectService = subjectService;
    }

    private final QuizService quizService;
    private final SubjectService subjectService;

    @GetMapping("/quizes")
    public Page getQuizes(@RequestParam(defaultValue = "0") int currentPage,
            @RequestParam(defaultValue = "2") int countPerPage,
            @RequestParam Long filterBySubject,
            @RequestParam(defaultValue = "id") String sort) {

        return quizService.getAll(currentPage, countPerPage, sort, filterBySubject);
    }

    @PostMapping("/quizes")
    public Quiz createQuiz(@RequestBody Quiz quiz) {

        return quizService.save(quiz);

    }

    @PutMapping("/quizes")
    public Quiz updateQuiz(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @GetMapping("/quizes/{id}")
    public Quiz getQuiz(@PathVariable Long id) {
       return quizService.read(id);
    }

    @ExceptionHandler({Exception.class})
    public String databaseError() {
        return "error-view-name";
    }

    @DeleteMapping("/quizes")
    public String deleteQuiz(Long testId) {
        quizService.delete(testId);
        return "Quiz deleted";
    }
}
