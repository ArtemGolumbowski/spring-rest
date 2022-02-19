/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.Subject;
import com.agolumbowski.spring.rest.quiz_rest.repository.SubjectRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;
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
public class SubjectServiceImplTest {

    public SubjectServiceImplTest() {
    }

    @Mock
    SubjectRepository subjectRepository;
    @InjectMocks
    SubjectServiceImpl instance;

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
    @Test
    public void testGetAllSubjects() {
        System.out.println("getAllSubjects");
        List<Subject> expResult = new ArrayList<>();
        expResult.add(new Subject("test", "test"));
        Mockito.when(subjectRepository.findAll()).thenReturn(expResult);
        List<Subject> result = instance.getAllSubjects();
        assertEquals(expResult, result);

    }

    /**
     * Test of getAll method, of class SubjectServiceImpl.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        int currentPage = 3;
        int countPerPage = 6;
        String sort = "id";
        Long filter = null;
        Page expResult = Mockito.mock(Page.class);
        ArgumentCaptor<PageRequest> pageRequestCaptor = ArgumentCaptor.forClass(PageRequest.class);
        Mockito.when(subjectRepository.findAll(pageRequestCaptor.capture())).thenReturn(expResult);
        Page result = instance.getAll(currentPage, countPerPage, sort, filter);
        assertEquals(expResult, result);
        assertEquals(pageRequestCaptor.getValue().getSort(), Sort.by(sort));
        assertEquals(pageRequestCaptor.getValue().getPageNumber(), currentPage);
        assertEquals(pageRequestCaptor.getValue().getPageSize(), countPerPage);
    }

    /**
     * Test of read method, of class SubjectServiceImpl.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        Long subjectId = 4L;
        Subject expResult = new Subject("test", "test");
        expResult.setId(subjectId);
        Optional<Subject> optional = Optional.of(expResult);
        Mockito.when(subjectRepository.findById(subjectId)).thenReturn(optional);
        Subject result = instance.read(subjectId);
        assertEquals(expResult, result);

    }

    /**
     * Test of save method, of class SubjectServiceImpl.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Subject expResult = new Subject("test", "test");
        Mockito.when(subjectRepository.save(expResult)).thenReturn(expResult);
        Subject result = instance.save(expResult);
        assertEquals(expResult, result);

    }

    /**
     * Test of delete method, of class SubjectServiceImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long id = 6L;
        instance.delete(id);
        Mockito.verify(subjectRepository).deleteById(id);

    }

}
