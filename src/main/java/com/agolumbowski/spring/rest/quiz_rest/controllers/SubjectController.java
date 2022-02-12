/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.controllers;

import com.agolumbowski.spring.rest.quiz_rest.entity.Subject;
import com.agolumbowski.spring.rest.quiz_rest.service.SubjectService;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
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
public class SubjectController {

    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public Page getSubjects(@RequestParam(defaultValue = "0") int currentPage,
            @RequestParam(defaultValue = "100") int countPerPage,
            @RequestParam(defaultValue = "id") String sort) {
        return subjectService.getAll(currentPage, countPerPage, sort, Long.MIN_VALUE);
    }

    @PostMapping("/subjects")
    public Subject createSubject(@RequestBody Subject subject) {

        return subjectService.save(subject);

    }

    @PutMapping("/subjects")
    public Subject editSubject(@RequestBody Subject subject) {
        return subjectService.save(subject);

    }

    @GetMapping("/subjects/{id}")
    public Subject getSubject(@PathVariable Long id) {

        return subjectService.read(id);
    }
}
