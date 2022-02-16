/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Subject;
import com.agolumbowski.spring.rest.quiz_rest.repository.SubjectRepository;
import com.agolumbowski.spring.rest.quiz_rest.service.SubjectService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author agolu
 */
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Page getAll(int currentPage, int countPerPage, String sort, Long filter) {
        return subjectRepository.findAll(PageRequest.of(currentPage, countPerPage, Sort.by(sort)));
    }

    @Override
    public Subject read(Long subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void delete(long id) {
        subjectRepository.deleteById(id);
    }

}
