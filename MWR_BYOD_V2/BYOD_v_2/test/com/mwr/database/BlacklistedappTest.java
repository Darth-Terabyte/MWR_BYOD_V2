/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madenem
 */
public class BlacklistedappTest {
    
    public BlacklistedappTest() {
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
     * Test of getAppId method, of class Blacklistedapp.
     */
    @Test
    public void testGetAppId() {
        System.out.println("getAppId");
        Blacklistedapp instance = new Blacklistedapp();
        Integer expResult = null;
        Integer result = instance.getAppId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppId method, of class Blacklistedapp.
     */
    @Test
    public void testSetAppId() {
        System.out.println("setAppId");
        Integer appId = null;
        Blacklistedapp instance = new Blacklistedapp();
        instance.setAppId(appId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppName method, of class Blacklistedapp.
     */
    @Test
    public void testGetAppName() {
        System.out.println("getAppName");
        Blacklistedapp instance = new Blacklistedapp();
        String expResult = "";
        String result = instance.getAppName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppName method, of class Blacklistedapp.
     */
    @Test
    public void testSetAppName() {
        System.out.println("setAppName");
        String appName = "";
        Blacklistedapp instance = new Blacklistedapp();
        instance.setAppName(appName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppCategory method, of class Blacklistedapp.
     */
    @Test
    public void testGetAppCategory() {
        System.out.println("getAppCategory");
        Blacklistedapp instance = new Blacklistedapp();
        String expResult = "";
        String result = instance.getAppCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppCategory method, of class Blacklistedapp.
     */
    @Test
    public void testSetAppCategory() {
        System.out.println("setAppCategory");
        String appCategory = "";
        Blacklistedapp instance = new Blacklistedapp();
        instance.setAppCategory(appCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}