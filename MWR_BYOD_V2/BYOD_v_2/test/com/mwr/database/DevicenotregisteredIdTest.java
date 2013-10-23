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
public class DevicenotregisteredIdTest {
    
    public DevicenotregisteredIdTest() {
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
     * Test of getMacaddress method, of class DevicenotregisteredId.
     */
    @Test
    public void testGetMacaddress() {
        System.out.println("getMacaddress");
        DevicenotregisteredId instance = new DevicenotregisteredId();
        String expResult = "";
        String result = instance.getMacaddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMacaddress method, of class DevicenotregisteredId.
     */
    @Test
    public void testSetMacaddress() {
        System.out.println("setMacaddress");
        String macaddress = "";
        DevicenotregisteredId instance = new DevicenotregisteredId();
        instance.setMacaddress(macaddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAndroidId method, of class DevicenotregisteredId.
     */
    @Test
    public void testGetAndroidId() {
        System.out.println("getAndroidId");
        DevicenotregisteredId instance = new DevicenotregisteredId();
        String expResult = "";
        String result = instance.getAndroidId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAndroidId method, of class DevicenotregisteredId.
     */
    @Test
    public void testSetAndroidId() {
        System.out.println("setAndroidId");
        String androidId = "";
        DevicenotregisteredId instance = new DevicenotregisteredId();
        instance.setAndroidId(androidId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSerialNumber method, of class DevicenotregisteredId.
     */
    @Test
    public void testGetSerialNumber() {
        System.out.println("getSerialNumber");
        DevicenotregisteredId instance = new DevicenotregisteredId();
        String expResult = "";
        String result = instance.getSerialNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSerialNumber method, of class DevicenotregisteredId.
     */
    @Test
    public void testSetSerialNumber() {
        System.out.println("setSerialNumber");
        String serialNumber = "";
        DevicenotregisteredId instance = new DevicenotregisteredId();
        instance.setSerialNumber(serialNumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class DevicenotregisteredId.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object other = null;
        DevicenotregisteredId instance = new DevicenotregisteredId();
        boolean expResult = false;
        boolean result = instance.equals(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class DevicenotregisteredId.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        DevicenotregisteredId instance = new DevicenotregisteredId();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}