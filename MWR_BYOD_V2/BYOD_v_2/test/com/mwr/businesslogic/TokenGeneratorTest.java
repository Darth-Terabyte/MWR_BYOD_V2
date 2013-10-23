/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.businesslogic;

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
public class TokenGeneratorTest {
    
    public TokenGeneratorTest() {
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
     * Test of generateToken method, of class TokenGenerator.
     */
    @Test
    public void testGenerateToken() throws Exception {
        System.out.println("generateToken");
        String mac = "";
        String uid = "";
        String serial = "";
        String password = "";
        TokenGenerator instance = new TokenGenerator();
        String expResult = "";
        String result = instance.generateToken(mac, uid, serial, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}