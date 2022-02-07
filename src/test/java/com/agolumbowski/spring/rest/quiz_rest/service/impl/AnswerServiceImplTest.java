/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Page;

/**
 *
 * @author agolu
 */
public class AnswerServiceImplTest {
    
    public AnswerServiceImplTest() {
    }

    @org.junit.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.junit.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
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
    @org.junit.Test
    public void testSave() {
        System.out.println("save");
        Answer answer = null;
        AnswerServiceImpl instance = null;
        Answer expResult = null;
        Answer result = instance.save(answer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class AnswerServiceImpl.
     */
    @org.junit.Test
    public void testRead() {
        System.out.println("read");
        Long answerId = null;
        AnswerServiceImpl instance = null;
        Answer expResult = null;
        Answer result = instance.read(answerId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class AnswerServiceImpl.
     */
    @org.junit.Test
    public void testDelete() {
        System.out.println("delete");
        long answerId = 0L;
        AnswerServiceImpl instance = null;
        instance.delete(answerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class AnswerServiceImpl.
     */
    @org.junit.Test
    public void testGetAll() {
        System.out.println("getAll");
        int currentPage = 0;
        int countPerPage = 0;
        String sort = "";
        Long questionId = null;
        AnswerServiceImpl instance = null;
        Page expResult = null;
        Page result = instance.getAll(currentPage, countPerPage, sort, questionId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
