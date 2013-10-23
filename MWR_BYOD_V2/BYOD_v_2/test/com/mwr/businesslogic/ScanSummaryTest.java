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
public class ScanSummaryTest {
    
    public ScanSummaryTest() {
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
     * Test of getSummary method, of class ScanSummary.
     */
    @Test
    public void testGetSummary() {
        System.out.println("getSummary");
        int rooted = 0;
        int debug = 0;
        int unknown = 0;
        int os = 0;
        int api_level = 0;
        String apps = "";
        int appScore = 0;
        int total = 0;
        ScanSummary instance = new ScanSummary();
        String expResult = "";
        String result = instance.getSummary(rooted, debug, unknown, os, api_level, apps, appScore, total);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}