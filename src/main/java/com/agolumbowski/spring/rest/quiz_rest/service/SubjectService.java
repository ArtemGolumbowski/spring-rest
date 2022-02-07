
package com.agolumbowski.spring.rest.quiz_rest.service;

import com.agolumbowski.spring.rest.quiz_rest.entity.Subject;
import java.util.List;

/**
 *
 * @author agolu
 */
public interface SubjectService extends Service<Subject> {

    public List<Subject> getAllSubjects();

}
