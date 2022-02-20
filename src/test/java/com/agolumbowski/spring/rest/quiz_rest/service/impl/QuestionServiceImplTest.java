/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 *
 * @author agolu
 */
//@RunWith(MockitoJUnitRunner.class) 
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@SpringBootTest
public class QuestionServiceImplTest {
    @Mock
    QuestionRepository questionRepository;
    @InjectMocks
    QuestionServiceImpl instance;
    public QuestionServiceImplTest() {
    }

 
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
   
    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAll method, of class QuestionServiceImpl.
     */
    @Test
    public void testGetAll_Long() {
        System.out.println("getAll");
        Long testId = 3l;
        List<Question> expResult = new ArrayList<>();
        expResult.add(new Question());
        Mockito.when(questionRepository.findAllByQuizId(testId)).thenReturn(expResult);
        List<Question> result = instance.getAll(testId);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of save method, of class QuestionServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Question expResult = new Question();
        expResult.setId(1);
        Mockito.when(questionRepository.save(expResult)).thenReturn(expResult);
        Question result = instance.save(expResult);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of read method, of class QuestionServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Long questionId = 5l;
        Question expResult = new Question();
        expResult.setId(questionId);
        Optional <Question>questionOptional=Optional.of(expResult);
        Mockito.when(questionRepository.findById(questionId)).thenReturn(questionOptional);
        Question result = instance.read(questionId);
        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class QuestionServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 2L;
        instance.delete(id);
        Mockito.verify(questionRepository).deleteById(id);
       
    }

    /**
     * Test of getAll method, of class QuestionServiceImpl.
     */
    @Test
    public void testGetAll_4args() {
        System.out.println("getAll");
        int currentPage = 1;
        int countPerPage = 2;
        String sort = "id";
        Long testId = 2l;       
        ArgumentCaptor<Pageable> captor = ArgumentCaptor.forClass(Pageable.class);
        ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);
        Page expResult = Mockito.mock(Page.class);
        Mockito.when(questionRepository.findAllByQuizId(longCaptor.capture(), captor.capture())).thenReturn(expResult);
        Page result = instance.getAll(currentPage, countPerPage, sort, testId);
        
        assertEquals(expResult, result);
        assertEquals(testId, longCaptor.getValue());
        assertEquals(currentPage, captor.getValue().getPageNumber());
        assertEquals(countPerPage, captor.getValue().getPageSize());
        assertEquals(Sort.by(sort), captor.getValue().getSort());
        
    }

    /**
     * Test of isCorrect method, of class QuestionServiceImpl.
     */
    @Test
    public void testIsCorrect() {
        System.out.println("isCorrect");
        
        Answer answer1 = new Answer("first", true);
        Answer answer2 = new Answer("second", true);
        List<Answer>userAnswers = new ArrayList<>();
        userAnswers.add(answer1);
        userAnswers.add(answer2);        
        Long questionId = 5L;
        
        Question questionWithUserAnswers = new Question();
        questionWithUserAnswers.setId(questionId);
        questionWithUserAnswers.setAnswers(userAnswers);
        
        Answer answer3 = new Answer("third", false);
        List<Answer>quizAnswers = new ArrayList<>();
        quizAnswers.add(answer1);
        quizAnswers.add(answer3);
        quizAnswers.add(answer2);
        
        Question quizQuestion = new Question();
        quizQuestion.setAnswers(quizAnswers);
        Mockito.when(questionRepository.getById(questionId)).thenReturn(quizQuestion);
        boolean expResult = true;
        boolean result = instance.isCorrect(questionWithUserAnswers);
        assertEquals(expResult, result);
        
    }
    
}
