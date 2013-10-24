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
        System.out.println("getSummary: All values 0");
        int rooted = 0;
        int debug = 0;
        int unknown = 0;
        int api_level = 0;
        String apps = "";
        int appScore = 0;
        int total = 0;
        ScanSummary instance = new ScanSummary();
        String expResult = "Total Score: 0";
        String result = instance.getSummary(rooted, debug, unknown, api_level, apps, appScore, total);
        assertEquals(expResult, result);
        
        System.out.println("getSummary: values = 10, apps empty");
        rooted = 10;
        debug = 10;
        unknown = 10;
        api_level = 10;
        apps = "";
        appScore = 10;
        total = 10;
        instance = new ScanSummary();
        expResult = "Device is rooted;USB Debugging is enabled;Applications from unknown sources are allowed;Android version is outdated;Total Score: 10";
        result = instance.getSummary(rooted, debug, unknown, api_level, apps, appScore, total);
        assertEquals(expResult, result);
        
        System.out.println("getSummary: values = 10, apps = None");
        rooted = 10;
        debug = 10;
        unknown = 10;
        api_level = 10;
        apps = "None";
        appScore = 10;
        total = 10;
        instance = new ScanSummary();
        expResult = "Device is rooted;USB Debugging is enabled;Applications from unknown sources are allowed;Android version is outdated;Total Score: 10";
        result = instance.getSummary(rooted, debug, unknown, api_level, apps, appScore, total);
        assertEquals(expResult, result);
        
      System.out.println("getSummary: values = 10, apps = Facebook, Skype");
        rooted = 10;
        debug = 10;
        unknown = 10;
        api_level = 10;
        apps = "Facebook, Skype";
        appScore = 10;
        total = 10;
        instance = new ScanSummary();
        expResult = "Device is rooted;USB Debugging is enabled;Applications from unknown sources are allowed;Android version is outdated;Blacklisted applications installed: Facebook, Skype;Total Score: 10";
        result = instance.getSummary(rooted, debug, unknown, api_level, apps, appScore, total);
        assertEquals(expResult, result);
       
    }
}