/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.repository.AnswerRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

/**
 *
 * @author agolu
 */
@SpringBootTest
public class AnswerServiceImplTest {
    
    @Mock
    AnswerRepository answerRepository;
    @InjectMocks
    AnswerServiceImpl instance;
    
    public AnswerServiceImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of save method, of class AnswerServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Answer expResult = new Answer("answer", true);
        Mockito.when(answerRepository.save(expResult)).thenReturn(expResult);
        Answer result = instance.save(expResult);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of read method, of class AnswerServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Long answerId = 3L;
        Answer expResult = new Answer("answer", true);
        expResult.setId(answerId);
        Mockito.when(answerRepository.getById(answerId)).thenReturn(expResult);
        Answer result = instance.read(answerId);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of delete method, of class AnswerServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long answerId = 6L;
        instance.delete(answerId);
        Mockito.verify(answerRepository).deleteById(answerId);
    }

    /**
     * Test of getAll method, of class AnswerServiceImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        int currentPage = 6;
        int countPerPage = 10;
        String sort = "id";
        Long questionId = 7L;
        Page expResult = null;
        Page result = instance.getAll(currentPage, countPerPage, sort, questionId);
        assertEquals(expResult, result);

    }
    
}
