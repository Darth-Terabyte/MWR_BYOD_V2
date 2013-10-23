/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Blacklistedapp;
import com.mwr.database.Setting;
import java.util.List;
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
public class SettingsBeanTest {
    
    public SettingsBeanTest() {
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
     * Test of getRootedWeight method, of class SettingsBean.
     */
    @Test
    public void testGetRootedWeight() {
        System.out.println("getRootedWeight");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getRootedWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDebugWeight method, of class SettingsBean.
     */
    @Test
    public void testGetDebugWeight() {
        System.out.println("getDebugWeight");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getDebugWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnknownSourcesWeight method, of class SettingsBean.
     */
    @Test
    public void testGetUnknownSourcesWeight() {
        System.out.println("getUnknownSourcesWeight");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getUnknownSourcesWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOsWeight method, of class SettingsBean.
     */
    @Test
    public void testGetOsWeight() {
        System.out.println("getOsWeight");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getOsWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowRiskApp method, of class SettingsBean.
     */
    @Test
    public void testGetLowRiskApp() {
        System.out.println("getLowRiskApp");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getLowRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediumRiskApp method, of class SettingsBean.
     */
    @Test
    public void testGetMediumRiskApp() {
        System.out.println("getMediumRiskApp");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getMediumRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighRiskApp method, of class SettingsBean.
     */
    @Test
    public void testGetHighRiskApp() {
        System.out.println("getHighRiskApp");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getHighRiskApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlockedApp method, of class SettingsBean.
     */
    @Test
    public void testGetBlockedApp() {
        System.out.println("getBlockedApp");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getBlockedApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAccessScore method, of class SettingsBean.
     */
    @Test
    public void testGetAccessScore() {
        System.out.println("getAccessScore");
        SettingsBean instance = new SettingsBean();
        int expResult = 0;
        int result = instance.getAccessScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRootedWeight method, of class SettingsBean.
     */
    @Test
    public void testSetRootedWeight() {
        System.out.println("setRootedWeight");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setRootedWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDebugWeight method, of class SettingsBean.
     */
    @Test
    public void testSetDebugWeight() {
        System.out.println("setDebugWeight");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setDebugWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnknownSourcesWeight method, of class SettingsBean.
     */
    @Test
    public void testSetUnknownSourcesWeight() {
        System.out.println("setUnknownSourcesWeight");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setUnknownSourcesWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOsWeight method, of class SettingsBean.
     */
    @Test
    public void testSetOsWeight() {
        System.out.println("setOsWeight");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setOsWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLowRiskApp method, of class SettingsBean.
     */
    @Test
    public void testSetLowRiskApp() {
        System.out.println("setLowRiskApp");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setLowRiskApp(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMediumRiskApp method, of class SettingsBean.
     */
    @Test
    public void testSetMediumRiskApp() {
        System.out.println("setMediumRiskApp");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setMediumRiskApp(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighRiskApp method, of class SettingsBean.
     */
    @Test
    public void testSetHighRiskApp() {
        System.out.println("setHighRiskApp");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setHighRiskApp(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlockedApp method, of class SettingsBean.
     */
    @Test
    public void testSetBlockedApp() {
        System.out.println("setBlockedApp");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setBlockedApp(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccessScore method, of class SettingsBean.
     */
    @Test
    public void testSetAccessScore() {
        System.out.println("setAccessScore");
        int weight = 0;
        SettingsBean instance = new SettingsBean();
        instance.setAccessScore(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppName method, of class SettingsBean.
     */
    @Test
    public void testGetAppName() {
        System.out.println("getAppName");
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.getAppName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppName method, of class SettingsBean.
     */
    @Test
    public void testSetAppName() {
        System.out.println("setAppName");
        String appName = "";
        SettingsBean instance = new SettingsBean();
        instance.setAppName(appName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAppCategory method, of class SettingsBean.
     */
    @Test
    public void testGetAppCategory() {
        System.out.println("getAppCategory");
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.getAppCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAppCategory method, of class SettingsBean.
     */
    @Test
    public void testSetAppCategory() {
        System.out.println("setAppCategory");
        String appCategory = "";
        SettingsBean instance = new SettingsBean();
        instance.setAppCategory(appCategory);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSetting method, of class SettingsBean.
     */
    @Test
    public void testSaveSetting() {
        System.out.println("saveSetting");
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.saveSetting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBlacklistedApp method, of class SettingsBean.
     */
    @Test
    public void testAddBlacklistedApp() {
        System.out.println("addBlacklistedApp");
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.addBlacklistedApp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatestSetting method, of class SettingsBean.
     */
    @Test
    public void testGetLatestSetting() {
        System.out.println("getLatestSetting");
        SettingsBean instance = new SettingsBean();
        Setting expResult = null;
        Setting result = instance.getLatestSetting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeApp method, of class SettingsBean.
     */
    @Test
    public void testRemoveApp() {
        System.out.println("removeApp");
        Blacklistedapp app = null;
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.removeApp(app);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSettings method, of class SettingsBean.
     */
    @Test
    public void testGetSettings() {
        System.out.println("getSettings");
        SettingsBean instance = new SettingsBean();
        List expResult = null;
        List result = instance.getSettings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowedScans method, of class SettingsBean.
     */
    @Test
    public void testGetAllowedScans() {
        System.out.println("getAllowedScans");
        SettingsBean instance = new SettingsBean();
        List expResult = null;
        List result = instance.getAllowedScans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeniedScans method, of class SettingsBean.
     */
    @Test
    public void testGetDeniedScans() {
        System.out.println("getDeniedScans");
        SettingsBean instance = new SettingsBean();
        List expResult = null;
        List result = instance.getDeniedScans();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSetting method, of class SettingsBean.
     */
    @Test
    public void testShowSetting() {
        System.out.println("showSetting");
        int id = 0;
        SettingsBean instance = new SettingsBean();
        String expResult = "";
        String result = instance.showSetting(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecificSetting method, of class SettingsBean.
     */
    @Test
    public void testGetSpecificSetting() {
        System.out.println("getSpecificSetting");
        SettingsBean instance = new SettingsBean();
        Setting expResult = null;
        Setting result = instance.getSpecificSetting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}