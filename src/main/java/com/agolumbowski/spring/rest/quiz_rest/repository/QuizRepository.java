/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.repository;

import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author agolu
 */
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    Page findBySubjectId(long subjectId, Pageable pageable);

}
