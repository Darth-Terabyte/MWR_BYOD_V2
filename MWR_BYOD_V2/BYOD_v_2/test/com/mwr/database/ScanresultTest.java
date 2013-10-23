/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.database;

import java.util.Date;
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
public class ScanresultTest {
    
    public ScanresultTest() {
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
     * Test of getScanId method, of class Scanresult.
     */
    @Test
    public void testGetScanId() {
        System.out.println("getScanId");
        Scanresult instance = new Scanresult();
        Integer expResult = null;
        Integer result = instance.getScanId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScanId method, of class Scanresult.
     */
    @Test
    public void testSetScanId() {
        System.out.println("setScanId");
        Integer scanId = null;
        Scanresult instance = new Scanresult();
        instance.setScanId(scanId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevice method, of class Scanresult.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        Scanresult instance = new Scanresult();
        Device expResult = null;
        Device result = instance.getDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDevice method, of class Scanresult.
     */
    @Test
    public void testSetDevice() {
        System.out.println("setDevice");
        Device device = null;
        Scanresult instance = new Scanresult();
        instance.setDevice(device);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSetting method, of class Scanresult.
     */
    @Test
    public void testGetSetting() {
        System.out.println("getSetting");
        Scanresult instance = new Scanresult();
        Setting expResult = null;
        Setting result = instance.getSetting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSetting method, of class Scanresult.
     */
    @Test
    public void testSetSetting() {
        System.out.println("setSetting");
        Setting setting = null;
        Scanresult instance = new Scanresult();
        instance.setSetting(setting);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Scanresult.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Scanresult instance = new Scanresult();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Scanresult.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Scanresult instance = new Scanresult();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRooted method, of class Scanresult.
     */
    @Test
    public void testIsRooted() {
        System.out.println("isRooted");
        Scanresult instance = new Scanresult();
        boolean expResult = false;
        boolean result = instance.isRooted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRooted method, of class Scanresult.
     */
    @Test
    public void testSetRooted() {
        System.out.println("setRooted");
        boolean rooted = false;
        Scanresult instance = new Scanresult();
        instance.setRooted(rooted);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRootedScore method, of class Scanresult.
     */
    @Test
    public void testGetRootedScore() {
        System.out.println("getRootedScore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getRootedScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRootedScore method, of class Scanresult.
     */
    @Test
    public void testSetRootedScore() {
        System.out.println("setRootedScore");
        int rootedScore = 0;
        Scanresult instance = new Scanresult();
        instance.setRootedScore(rootedScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDebuggingEnabled method, of class Scanresult.
     */
    @Test
    public void testIsDebuggingEnabled() {
        System.out.println("isDebuggingEnabled");
        Scanresult instance = new Scanresult();
        boolean expResult = false;
        boolean result = instance.isDebuggingEnabled();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebuggingEnabled method, of class Scanresult.
     */
    @Test
    public void testSetDebuggingEnabled() {
        System.out.println("setDebuggingEnabled");
        boolean debuggingEnabled = false;
        Scanresult instance = new Scanresult();
        instance.setDebuggingEnabled(debuggingEnabled);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebuggingEnabledScore method, of class Scanresult.
     */
    @Test
    public void testGetDebuggingEnabledScore() {
        System.out.println("getDebuggingEnabledScore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getDebuggingEnabledScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebuggingEnabledScore method, of class Scanresult.
     */
    @Test
    public void testSetDebuggingEnabledScore() {
        System.out.println("setDebuggingEnabledScore");
        int debuggingEnabledScore = 0;
        Scanresult instance = new Scanresult();
        instance.setDebuggingEnabledScore(debuggingEnabledScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isUnknownSourcesAllowed method, of class Scanresult.
     */
    @Test
    public void testIsUnknownSourcesAllowed() {
        System.out.println("isUnknownSourcesAllowed");
        Scanresult instance = new Scanresult();
        boolean expResult = false;
        boolean result = instance.isUnknownSourcesAllowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnknownSourcesAllowed method, of class Scanresult.
     */
    @Test
    public void testSetUnknownSourcesAllowed() {
        System.out.println("setUnknownSourcesAllowed");
        boolean unknownSourcesAllowed = false;
        Scanresult instance = new Scanresult();
        instance.setUnknownSourcesAllowed(unknownSourcesAllowed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnknownSourcesScore method, of class Scanresult.
     */
    @Test
    public void testGetUnknownSourcesScore() {
        System.out.println("getUnknownSourcesScore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getUnknownSourcesScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnknownSourcesScore method, of class Scanresult.
     */
    @Test
    public void testSetUnknownSourcesScore() {
        System.out.println("setUnknownSourcesScore");
        int unknownSourcesScore = 0;
        Scanresult instance = new Scanresult();
        instance.setUnknownSourcesScore(unknownSourcesScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlacklistedApps method, of class Scanresult.
     */
    @Test
    public void testGetBlacklistedApps() {
        System.out.println("getBlacklistedApps");
        Scanresult instance = new Scanresult();
        String expResult = "";
        String result = instance.getBlacklistedApps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlacklistedApps method, of class Scanresult.
     */
    @Test
    public void testSetBlacklistedApps() {
        System.out.println("setBlacklistedApps");
        String blacklistedApps = "";
        Scanresult instance = new Scanresult();
        instance.setBlacklistedApps(blacklistedApps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppsScore method, of class Scanresult.
     */
    @Test
    public void testGetAppsScore() {
        System.out.println("getAppsScore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getAppsScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppsScore method, of class Scanresult.
     */
    @Test
    public void testSetAppsScore() {
        System.out.println("setAppsScore");
        int appsScore = 0;
        Scanresult instance = new Scanresult();
        instance.setAppsScore(appsScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApilevel method, of class Scanresult.
     */
    @Test
    public void testGetApilevel() {
        System.out.println("getApilevel");
        Scanresult instance = new Scanresult();
        String expResult = "";
        String result = instance.getApilevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApilevel method, of class Scanresult.
     */
    @Test
    public void testSetApilevel() {
        System.out.println("setApilevel");
        String apilevel = "";
        Scanresult instance = new Scanresult();
        instance.setApilevel(apilevel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApiscore method, of class Scanresult.
     */
    @Test
    public void testGetApiscore() {
        System.out.println("getApiscore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getApiscore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApiscore method, of class Scanresult.
     */
    @Test
    public void testSetApiscore() {
        System.out.println("setApiscore");
        int apiscore = 0;
        Scanresult instance = new Scanresult();
        instance.setApiscore(apiscore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalScore method, of class Scanresult.
     */
    @Test
    public void testGetTotalScore() {
        System.out.println("getTotalScore");
        Scanresult instance = new Scanresult();
        int expResult = 0;
        int result = instance.getTotalScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalScore method, of class Scanresult.
     */
    @Test
    public void testSetTotalScore() {
        System.out.println("setTotalScore");
        int totalScore = 0;
        Scanresult instance = new Scanresult();
        instance.setTotalScore(totalScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccessAllowed method, of class Scanresult.
     */
    @Test
    public void testIsAccessAllowed() {
        System.out.println("isAccessAllowed");
        Scanresult instance = new Scanresult();
        boolean expResult = false;
        boolean result = instance.isAccessAllowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccessAllowed method, of class Scanresult.
     */
    @Test
    public void testSetAccessAllowed() {
        System.out.println("setAccessAllowed");
        boolean accessAllowed = false;
        Scanresult instance = new Scanresult();
        instance.setAccessAllowed(accessAllowed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}