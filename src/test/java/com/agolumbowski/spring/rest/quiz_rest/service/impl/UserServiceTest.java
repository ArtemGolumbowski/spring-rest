/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.agolumbowski.spring.rest.quiz_rest.service.impl;

import com.agolumbowski.spring.rest.quiz_rest.entity.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author agolu
 */
public class UserServiceTest {
    
    public UserServiceTest() {
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
     * Test of getAllUsers method, of class UserService.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        int page = 0;
        UserService instance = null;
        Page expResult = null;
        Page result = instance.getAllUsers(page);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadUserByUsername method, of class UserService.
     */
    @Test
    public void testLoadUserByUsername() {
        System.out.println("loadUserByUsername");
        String username = "";
        UserService instance = null;
        UserDetails expResult = null;
        UserDetails result = instance.loadUserByUsername(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserService.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        User user = null;
        UserService instance = null;
        User expResult = null;
        User result = instance.save(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        UserService instance = null;
        instance.addUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserIsExist method, of class UserService.
     */
    @Test
    public void testCheckUserIsExist() {
        System.out.println("checkUserIsExist");
        User user = null;
        UserService instance = null;
        boolean expResult = false;
        boolean result = instance.checkUserIsExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserService.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        long userId = 0L;
        UserService instance = null;
        instance.delete(userId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of read method, of class UserService.
     */
    @Test
    public void testRead() {
        System.out.println("read");
        long userId = 0L;
        UserService instance = null;
        User expResult = null;
        User result = instance.read(userId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
