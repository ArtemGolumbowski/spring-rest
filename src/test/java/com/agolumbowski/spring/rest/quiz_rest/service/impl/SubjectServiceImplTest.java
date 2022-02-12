/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Subject;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

/**
 *
 * @author agolu
 */
@SpringBootTest
public class SubjectServiceImplTest {
    
    public SubjectServiceImplTest() {
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
     * Test of getAllSubjects method, of class SubjectServiceImpl.
     */
    @org.junit.Test
    public void testGetAllSubjects() {
        System.out.println("getAllSubjects");
        SubjectServiceImpl instance = null;
        List<Subject> expResult = null;
        List<Subject> result = instance.getAllSubjects();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAll method, of class SubjectServiceImpl.
     */
    @org.junit.Test
    public void testGetAll() {
        System.out.println("getAll");
        int currentPage = 0;
        int countPerPage = 0;
        String sort = "";
        Long filter = null;
        SubjectServiceImpl instance = null;
        Page expResult = null;
        Page result = instance.getAll(currentPage, countPerPage, sort, filter);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class SubjectServiceImpl.
     */
    @org.junit.Test
    public void testRead() {
        System.out.println("read");
        Long subjectId = null;
        SubjectServiceImpl instance = null;
        Subject expResult = null;
        Subject result = instance.read(subjectId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class SubjectServiceImpl.
     */
    @org.junit.Test
    public void testSave() {
        System.out.println("save");
        Subject subject = null;
        SubjectServiceImpl instance = null;
        Subject expResult = null;
        Subject result = instance.save(subject);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SubjectServiceImpl.
     */
    @org.junit.Test
    public void testDelete() {
        System.out.println("delete");
        long id = 0L;
        SubjectServiceImpl instance = null;
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
