/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Answer;
import com.agolumbowski.spring.rest.quiz_rest.entity.Question;
import com.agolumbowski.spring.rest.quiz_rest.entity.Quiz;
import com.agolumbowski.spring.rest.quiz_rest.entity.User;
import com.agolumbowski.spring.rest.quiz_rest.repository.QuizRepository;
import com.agolumbowski.spring.rest.quiz_rest.service.QuestionService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 *
 * @author agolu
 */
@SpringBootTest
public class QuizServiceImplTest {

    private static final String START_QUIZ_TIME = "start";
    private static final String RIGHT_ANSWER_COUNT = "rightAnswerCount";
    private static final String CURRENT_QUESTION = "currentQuestion";
    @Mock
    QuizRepository quizRepository;
    @Mock
    UserService userService;
    @Mock
    HttpSession httpSession;
    @Mock
    QuestionService questionService;
    @InjectMocks
    QuizServiceImpl instance;

    public QuizServiceImplTest() {
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
    @Test
    public void testSave() {
        System.out.println("save");
        Quiz expResult = new Quiz();
        expResult.setDescription("test description");
        Mockito.when(quizRepository.save(expResult)).thenReturn(expResult);
        Quiz result = instance.save(expResult);
        assertEquals(expResult.getDescription(), result.getDescription());

    }

    /**
     * Test of read method, of class QuizServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Long id = 8L;
        Quiz expResult = new Quiz();
        expResult.setId(8L);
        Mockito.when(quizRepository.getById(id)).thenReturn(expResult);
        Quiz result = instance.read(id);
        assertEquals(expResult.getId(), result.getId());
    }

    /**
     * Test of delete method, of class QuizServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 8L;
        instance.delete(id);
        Mockito.verify(quizRepository).deleteById(id);

    }

    /**
     * Test of getAll method, of class QuizServiceImpl.
     */
    @Test
    public void testGetAllWithSubjectId() {
        System.out.println("getAll");
        int currentPage = 3;
        int countPerPage = 6;
        String sort = "Math";
        Long subjectId = 4L;
        Page expResult = Mockito.mock(Page.class);
        ArgumentCaptor<PageRequest> pageRequestCaptor = ArgumentCaptor.forClass(PageRequest.class);
        ArgumentCaptor<Long> longCaptor = ArgumentCaptor.forClass(Long.class);
        Mockito.when(quizRepository.findBySubjectId(longCaptor.capture(), pageRequestCaptor.capture())).thenReturn(expResult);
        Page result = instance.getAll(currentPage, countPerPage, sort, subjectId);
        assertEquals(expResult, result);
        assertEquals(longCaptor.getValue(), subjectId);
        assertEquals(pageRequestCaptor.getValue().getSort(), Sort.by(sort));
        assertEquals(pageRequestCaptor.getValue().getPageNumber(), currentPage);
        assertEquals(pageRequestCaptor.getValue().getPageSize(), countPerPage);
    }

    /**
     * Test of startQuiz method, of class QuizServiceImpl.
     */
    @Test
    public void testStartQuiz() {
        System.out.println("startQuiz");
        instance.startQuiz();

        Mockito.verify(httpSession).setAttribute(RIGHT_ANSWER_COUNT, 0);
        Mockito.verify(httpSession).setAttribute(CURRENT_QUESTION, 0);
    }

    /**
     * Test of getCurrentQuestion method, of class QuizServiceImpl.
     */
    @Test
    public void testGetCurrentQuestion() {
        System.out.println("getCurrentQuestion");
        Long quizId = 5L;

        Question expResult = new Question();
        expResult.setId(6);
        Mockito.when(httpSession.getAttribute(CURRENT_QUESTION)).thenReturn(1);
        Quiz quiz = Mockito.mock(Quiz.class);
        Mockito.when(quizRepository.getById(quizId)).thenReturn(quiz);
        List<Question> questions = new ArrayList<>();
        Question firstQuestion = new Question();
        questions.add(firstQuestion);
        questions.add(expResult);
        Mockito.when(quiz.getQuestions()).thenReturn(questions);
        Question result = instance.getCurrentQuestion(quizId);
        System.out.println(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of quizCheckUserAnswers method, of class QuizServiceImpl.
     */
    @Test
    public void testQuizCheckUserAnswers() {
        System.out.println("quizCheckUserAnswers");
        Question questionWithUserAnswers = new Question();
        questionWithUserAnswers.setAnswers(new ArrayList<Answer>());
        questionWithUserAnswers.getAnswers().add(new Answer("first", true));
        questionWithUserAnswers.getAnswers().add(new Answer("second", false));
        Quiz quiz=new Quiz();
        quiz.setQuestions(new ArrayList<Question>());
        quiz.getQuestions().add(new Question());
        quiz.getQuestions().add(questionWithUserAnswers);
        User user = new User();
        Long quizId = 6L;
        
        Mockito.when(httpSession.getAttribute(CURRENT_QUESTION)).thenReturn(1);
        Mockito.when(httpSession.getAttribute(RIGHT_ANSWER_COUNT)).thenReturn(1);
        Mockito.when(quizRepository.getById(quizId)).thenReturn(quiz);
        Mockito.when(questionService.isCorrect(questionWithUserAnswers)).thenReturn(true);
        String expResult = "redirect:/quizzing/" + quizId;
        String result = instance.quizCheckUserAnswers(questionWithUserAnswers, user, quizId);
        assertEquals(expResult, result);
    }

    /**
     * Test of finishQuiz method, of class QuizServiceImpl.
     */
//    @Test
//    public void testFinishQuiz() {
//        System.out.println("finishQuiz");
//        User user = null;
//        Long quizId = null;
//        String expResult = "";
//        String result = instance.finishQuiz(user, quizId);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

}
