/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author agolu
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.agolumbowski.spring.rest.quiz_rest.service.impl.QuizServiceImplTest.class, com.agolumbowski.spring.rest.quiz_rest.service.impl.QuestionServiceImplTest.class, com.agolumbowski.spring.rest.quiz_rest.service.impl.SubjectServiceImplTest.class, com.agolumbowski.spring.rest.quiz_rest.service.impl.AnswerServiceImplTest.class, com.agolumbowski.spring.rest.quiz_rest.service.impl.UserServiceTest.class})
public class ImplSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
