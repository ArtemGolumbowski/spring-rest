
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.exceptions.MyNoSuchElementException;
import com.agolumbowski.spring.rest.quiz_rest.repository.AnswerRepository;
import com.agolumbowski.spring.rest.quiz_rest.service.AnswerService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class AnswerServiceImpl implements AnswerService {

    public AnswerServiceImpl(AnswerRepository answerRepository) {

        this.answerRepository = answerRepository;
    }

    private final AnswerRepository answerRepository;

    /**
     *
     * @param answer
     * @return
     */
    @Override
    public Answer save(Answer answer) {

        return answerRepository.save(answer);

    }

    @Override
    public Answer read(Long answerId) {  
        Optional<Answer>answerOptional=answerRepository.findById(answerId);
        if(answerOptional.isEmpty()){
            throw new MyNoSuchElementException("There is no subject with id= "+answerId+" in DataBase");
        }
            return answerOptional.get();
    }

    @Override
    public void delete(long answerId) {
        
        answerRepository.deleteById(answerId);
        
    }

    @Override
    public Page getAll(int currentPage, int countPerPage, String sort, Long questionId) {
        
        return answerRepository.findAllByQuestionId(questionId, 
                PageRequest.of(currentPage, countPerPage, Sort.by(sort)));
        
    }
}
