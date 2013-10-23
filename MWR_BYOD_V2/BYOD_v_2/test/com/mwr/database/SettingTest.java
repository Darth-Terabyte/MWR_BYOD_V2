/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.database;

import java.util.Date;
import java.util.Set;
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
public class SettingTest {
    
    public SettingTest() {
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
     * Test of getSettingId method, of class Setting.
     */
    @Test
    public void testGetSettingId() {
        System.out.println("getSettingId");
        Setting instance = new Setting();
        Integer expResult = null;
        Integer result = instance.getSettingId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSettingId method, of class Setting.
     */
    @Test
    public void testSetSettingId() {
        System.out.println("setSettingId");
        Integer settingId = null;
        Setting instance = new Setting();
        instance.setSettingId(settingId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccessScore method, of class Setting.
     */
    @Test
    public void testGetAccessScore() {
        System.out.println("getAccessScore");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getAccessScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccessScore method, of class Setting.
     */
    @Test
    public void testSetAccessScore() {
        System.out.println("setAccessScore");
        int accessScore = 0;
        Setting instance = new Setting();
        instance.setAccessScore(accessScore);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSettingDate method, of class Setting.
     */
    @Test
    public void testGetSettingDate() {
        System.out.println("getSettingDate");
        Setting instance = new Setting();
        Date expResult = null;
        Date result = instance.getSettingDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSettingDate method, of class Setting.
     */
    @Test
    public void testSetSettingDate() {
        System.out.println("setSettingDate");
        Date settingDate = null;
        Setting instance = new Setting();
        instance.setSettingDate(settingDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApiweight method, of class Setting.
     */
    @Test
    public void testGetApiweight() {
        System.out.println("getApiweight");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getApiweight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApiweight method, of class Setting.
     */
    @Test
    public void testSetApiweight() {
        System.out.println("setApiweight");
        int apiweight = 0;
        Setting instance = new Setting();
        instance.setApiweight(apiweight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRootedWeight method, of class Setting.
     */
    @Test
    public void testGetRootedWeight() {
        System.out.println("getRootedWeight");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getRootedWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRootedWeight method, of class Setting.
     */
    @Test
    public void testSetRootedWeight() {
        System.out.println("setRootedWeight");
        int rootedWeight = 0;
        Setting instance = new Setting();
        instance.setRootedWeight(rootedWeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebugWeight method, of class Setting.
     */
    @Test
    public void testGetDebugWeight() {
        System.out.println("getDebugWeight");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getDebugWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebugWeight method, of class Setting.
     */
    @Test
    public void testSetDebugWeight() {
        System.out.println("setDebugWeight");
        int debugWeight = 0;
        Setting instance = new Setting();
        instance.setDebugWeight(debugWeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnknownSourcesWeight method, of class Setting.
     */
    @Test
    public void testGetUnknownSourcesWeight() {
        System.out.println("getUnknownSourcesWeight");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getUnknownSourcesWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnknownSourcesWeight method, of class Setting.
     */
    @Test
    public void testSetUnknownSourcesWeight() {
        System.out.println("setUnknownSourcesWeight");
        int unknownSourcesWeight = 0;
        Setting instance = new Setting();
        instance.setUnknownSourcesWeight(unknownSourcesWeight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowRiskApp method, of class Setting.
     */
    @Test
    public void testGetLowRiskApp() {
        System.out.println("getLowRiskApp");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getLowRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLowRiskApp method, of class Setting.
     */
    @Test
    public void testSetLowRiskApp() {
        System.out.println("setLowRiskApp");
        int lowRiskApp = 0;
        Setting instance = new Setting();
        instance.setLowRiskApp(lowRiskApp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediumRiskApp method, of class Setting.
     */
    @Test
    public void testGetMediumRiskApp() {
        System.out.println("getMediumRiskApp");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getMediumRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMediumRiskApp method, of class Setting.
     */
    @Test
    public void testSetMediumRiskApp() {
        System.out.println("setMediumRiskApp");
        int mediumRiskApp = 0;
        Setting instance = new Setting();
        instance.setMediumRiskApp(mediumRiskApp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighRiskApp method, of class Setting.
     */
    @Test
    public void testGetHighRiskApp() {
        System.out.println("getHighRiskApp");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getHighRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighRiskApp method, of class Setting.
     */
    @Test
    public void testSetHighRiskApp() {
        System.out.println("setHighRiskApp");
        int highRiskApp = 0;
        Setting instance = new Setting();
        instance.setHighRiskApp(highRiskApp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlockedApp method, of class Setting.
     */
    @Test
    public void testGetBlockedApp() {
        System.out.println("getBlockedApp");
        Setting instance = new Setting();
        int expResult = 0;
        int result = instance.getBlockedApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlockedApp method, of class Setting.
     */
    @Test
    public void testSetBlockedApp() {
        System.out.println("setBlockedApp");
        int blockedApp = 0;
        Setting instance = new Setting();
        instance.setBlockedApp(blockedApp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScanresults method, of class Setting.
     */
    @Test
    public void testGetScanresults() {
        System.out.println("getScanresults");
        Setting instance = new Setting();
        Set expResult = null;
        Set result = instance.getScanresults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScanresults method, of class Setting.
     */
    @Test
    public void testSetScanresults() {
        System.out.println("setScanresults");
        Set scanresults = null;
        Setting instance = new Setting();
        instance.setScanresults(scanresults);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}