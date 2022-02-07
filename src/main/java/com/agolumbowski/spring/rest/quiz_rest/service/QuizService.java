package com.agolumbowski.spring.rest.quiz_rest.service;

import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import com.agolumbowski.spring.rest.quiz_rest.entity.User;

/**
 *
 * @author agolu
 */
public interface QuizService extends Service<Quiz> {

    public void startQuiz();

    public Question getCurrentQuestion(long quizId);

    public String quizCheckUserAnswers(Question questionWithUserAnswers,
            User user,
            Long quizId);

    public String finishQuiz(User user, Long quizId);
}
