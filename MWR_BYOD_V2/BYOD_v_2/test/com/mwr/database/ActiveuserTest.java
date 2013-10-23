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
public class ActiveuserTest {
    
    public ActiveuserTest() {
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
     * Test of getIp method, of class Activeuser.
     */
    @Test
    public void testGetIp() {
        System.out.println("getIp");
        Activeuser instance = new Activeuser();
        String expResult = "";
        String result = instance.getIp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIp method, of class Activeuser.
     */
    @Test
    public void testSetIp() {
        System.out.println("setIp");
        String ip = "";
        Activeuser instance = new Activeuser();
        instance.setIp(ip);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceMacaddress method, of class Activeuser.
     */
    @Test
    public void testGetDeviceMacaddress() {
        System.out.println("getDeviceMacaddress");
        Activeuser instance = new Activeuser();
        String expResult = "";
        String result = instance.getDeviceMacaddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeviceMacaddress method, of class Activeuser.
     */
    @Test
    public void testSetDeviceMacaddress() {
        System.out.println("setDeviceMacaddress");
        String deviceMacaddress = "";
        Activeuser instance = new Activeuser();
        instance.setDeviceMacaddress(deviceMacaddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceAndroidId method, of class Activeuser.
     */
    @Test
    public void testGetDeviceAndroidId() {
        System.out.println("getDeviceAndroidId");
        Activeuser instance = new Activeuser();
        String expResult = "";
        String result = instance.getDeviceAndroidId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeviceAndroidId method, of class Activeuser.
     */
    @Test
    public void testSetDeviceAndroidId() {
        System.out.println("setDeviceAndroidId");
        String deviceAndroidId = "";
        Activeuser instance = new Activeuser();
        instance.setDeviceAndroidId(deviceAndroidId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceSerialNumber method, of class Activeuser.
     */
    @Test
    public void testGetDeviceSerialNumber() {
        System.out.println("getDeviceSerialNumber");
        Activeuser instance = new Activeuser();
        String expResult = "";
        String result = instance.getDeviceSerialNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDeviceSerialNumber method, of class Activeuser.
     */
    @Test
    public void testSetDeviceSerialNumber() {
        System.out.println("setDeviceSerialNumber");
        String deviceSerialNumber = "";
        Activeuser instance = new Activeuser();
        instance.setDeviceSerialNumber(deviceSerialNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}