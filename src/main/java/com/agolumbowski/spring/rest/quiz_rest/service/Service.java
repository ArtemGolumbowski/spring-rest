/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agolumbowski.spring.rest.quiz_rest.service;

import org.springframework.data.domain.Page;

public interface Service<T> {

    public T save(T t);

    public T read(Long id);

    public void delete(long id);
    
    public Page getAll(int currentPage, int countPerPage, String sort, Long filter);
}
