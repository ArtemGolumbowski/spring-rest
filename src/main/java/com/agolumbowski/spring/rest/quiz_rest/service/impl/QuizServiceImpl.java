package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import com.agolumbowski.spring.rest.quiz_rest.entity.User;
import com.agolumbowski.spring.rest.quiz_rest.entity.UserQuizResult;
import com.agolumbowski.spring.rest.quiz_rest.repository.QuizRepository;
import com.agolumbowski.spring.rest.quiz_rest.service.QuestionService;
import com.agolumbowski.spring.rest.quiz_rest.service.QuizService;
import java.time.Duration;
import java.time.LocalDateTime;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuizServiceImpl implements QuizService {

    private static final String START_QUIZ_TIME = "start";
    private static final String RIGHT_ANSWER_COUNT = "rightAnswerCount";
    private static final String CURRENT_QUESTION = "currentQuestion";

    private final QuizRepository quizRepository;
    private final UserService userService;
    @Autowired
    private final HttpSession httpSession;
    private final QuestionService questionService;

    public QuizServiceImpl(QuizRepository quizRepository, UserService userService, HttpSession httpSession, QuestionService questionService) {
        this.quizRepository = quizRepository;
        this.userService = userService;
        this.httpSession = httpSession;
        this.questionService = questionService;
    }

    @Override
    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz read(Long id) {
        return quizRepository.getById(id);
    }

    @Override
    public void delete(long id) {
        quizRepository.deleteById(id);
    }

    @Override
    public Page getAll(int currentPage, int countPerPage, String sort, Long subjectId) {
        if (subjectId == null) {
            return quizRepository.findAll(PageRequest.of(currentPage, countPerPage, Sort.by(sort)));
        } else {
            return quizRepository.findBySubjectId(subjectId,
                    PageRequest.of(currentPage, currentPage, Sort.by(sort)));
        }

    }

    @Override
    public void startQuiz() {
        LocalDateTime start = LocalDateTime.now();
        httpSession.setAttribute(START_QUIZ_TIME, start);
        httpSession.setAttribute(RIGHT_ANSWER_COUNT, 0);
        httpSession.setAttribute(CURRENT_QUESTION, 0);
    }

    @Override
    public Question getCurrentQuestion(long quizId) {
        int currentQuestion = (Integer) httpSession.getAttribute(CURRENT_QUESTION);
        return quizRepository.getById(quizId).getQuestions().get(currentQuestion);
    }

    @Override
    public String quizCheckUserAnswers(Question questionWithUserAnswers, User user, Long quizId) {
        int currentQuestion = (Integer) httpSession.getAttribute(CURRENT_QUESTION);
        Quiz currentQuiz = quizRepository.getById(quizId);
        int size = currentQuiz.getQuestions().size();
        int rightAnswerCount = (Integer) httpSession.getAttribute(RIGHT_ANSWER_COUNT);

        if (questionService.isCorrect(questionWithUserAnswers)) {

            rightAnswerCount++;
        }
        if (currentQuestion + 1 >= size) {

            return finishQuiz(user, quizId);

        } else {
            currentQuestion++;
            httpSession.setAttribute(RIGHT_ANSWER_COUNT, rightAnswerCount);
            httpSession.setAttribute(CURRENT_QUESTION, currentQuestion);
        }
        return "redirect:/quizzing/" + quizId;
    }

    @Override
    public String finishQuiz(User user, Long quizId) {
        LocalDateTime finishTime = LocalDateTime.now();
        Quiz currentQuiz = quizRepository.getById(quizId);
        LocalDateTime start = (LocalDateTime) httpSession.getAttribute(START_QUIZ_TIME);
        int rightAnswerCount = (Integer) httpSession.getAttribute(RIGHT_ANSWER_COUNT);
        long userTime = Duration.between(start, finishTime).toMinutes();
        int result = rightAnswerCount * 100 / currentQuiz.getQuestions().size();
        UserQuizResult userTestBean = new UserQuizResult(user, currentQuiz, result, userTime, finishTime);
        user.addUserQuizResult(userTestBean);
        userService.save(user);
        httpSession.removeAttribute(START_QUIZ_TIME);
        httpSession.removeAttribute(RIGHT_ANSWER_COUNT);
        httpSession.removeAttribute(CURRENT_QUESTION);
        return "redirect:/results";
    }
}
