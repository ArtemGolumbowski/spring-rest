
package com.agolumbowski.spring.rest.quiz_rest.service;
import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import java.util.List;

/**
 *
 * @author agolu
 */
public interface QuestionService extends Service<Question> {
    public List<Question> getAll(Long testId); 
    public boolean isCorrect(Question questionWithUserAnswers);
}
