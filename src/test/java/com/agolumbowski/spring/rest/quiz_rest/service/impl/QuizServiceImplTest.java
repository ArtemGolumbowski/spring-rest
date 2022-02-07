/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import com.agolumbowski.spring.rest.quiz_rest.entity.User;
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
public class QuizServiceImplTest {
    
    public QuizServiceImplTest() {
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
     * Test of save method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testSave() {
        System.out.println("save");
        Quiz quiz = null;
        QuizServiceImpl instance = null;
        Quiz expResult = null;
        Quiz result = instance.save(quiz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testRead() {
        System.out.println("read");
        Long id = null;
        QuizServiceImpl instance = null;
        Quiz expResult = null;
        Quiz result = instance.read(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
        QuizServiceImpl instance = null;
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testGetAll() {
        System.out.println("getAll");
        int currentPage = 0;
        int countPerPage = 0;
        String sort = "";
        Long subjectId = null;
        QuizServiceImpl instance = null;
        Page expResult = null;
        Page result = instance.getAll(currentPage, countPerPage, sort, subjectId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of startQuiz method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testStartQuiz() {
        System.out.println("startQuiz");
        QuizServiceImpl instance = null;
        instance.startQuiz();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentQuestion method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testGetCurrentQuestion() {
        System.out.println("getCurrentQuestion");
        long quizId = 0L;
        QuizServiceImpl instance = null;
        Question expResult = null;
        Question result = instance.getCurrentQuestion(quizId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quizCheckUserAnswers method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testQuizCheckUserAnswers() {
        System.out.println("quizCheckUserAnswers");
        Question questionWithUserAnswers = null;
        User user = null;
        Long quizId = null;
        QuizServiceImpl instance = null;
        String expResult = "";
        String result = instance.quizCheckUserAnswers(questionWithUserAnswers, user, quizId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finishQuiz method, of class QuizServiceImpl.
     */
    @org.junit.Test
    public void testFinishQuiz() {
        System.out.println("finishQuiz");
        User user = null;
        Long quizId = null;
        QuizServiceImpl instance = null;
        String expResult = "";
        String result = instance.finishQuiz(user, quizId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
