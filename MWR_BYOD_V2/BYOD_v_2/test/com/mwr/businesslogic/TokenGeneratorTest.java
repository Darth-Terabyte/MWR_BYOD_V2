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
    public void testGenerateTokenNonEmpty() throws Exception {
        System.out.println("generateToken: Non-empty strings");
        String mac = "CC:FE:3C:3C:15:02";
        String uid = "832e90701f904ad9";
        String serial = "unknown";
        String password = "7cf2db5ec261a0fa27a502d3196a6f60";
        TokenGenerator instance = new TokenGenerator();
        String expResult = "cef59";
        String result = instance.generateToken(mac, uid, serial, password);
        assertEquals(expResult, result);
        
      
        
    }
    
 
}