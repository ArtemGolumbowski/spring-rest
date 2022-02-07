package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.repository.QuestionRepository;
import com.agolumbowski.spring.rest.quiz_rest.service.QuestionService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAll(Long testId) {
        return questionRepository.findAllByQuizId(testId);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question read(Long questionId) {
        return questionRepository.getById(questionId);
    }

    @Override
    public void delete(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page getAll(int currentPage, int countPerPage, String sort, Long testId) {
        return questionRepository.findAllByQuizId(testId,
                PageRequest.of(currentPage, countPerPage, Sort.by(sort)));
    }

    @Override
    public boolean isCorrect(Question questionWithUserAnswers) {

        if (questionWithUserAnswers == null || questionWithUserAnswers.getAnswers().isEmpty()) {
            return false;
        } else {
            Question question = questionRepository.getById(questionWithUserAnswers.getId());
            List<Answer> correctAnswers = question.getAnswers()
                    .stream().filter(answer -> answer.isCorrect()).collect(Collectors.toList());
            if (questionWithUserAnswers.getAnswers().equals(correctAnswers)) {
                return true;
            }
        }
        return false;
    }

}
