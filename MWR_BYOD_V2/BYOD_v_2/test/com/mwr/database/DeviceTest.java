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
public class DeviceTest {
    
    public DeviceTest() {
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
     * Test of getId method, of class Device.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Device instance = new Device();
        DeviceId expResult = null;
        DeviceId result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Device.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        DeviceId id = null;
        Device instance = new Device();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class Device.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        Device instance = new Device();
        Employee expResult = null;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmployee method, of class Device.
     */
    @Test
    public void testSetEmployee() {
        System.out.println("setEmployee");
        Employee employee = null;
        Device instance = new Device();
        instance.setEmployee(employee);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getManufacturer method, of class Device.
     */
    @Test
    public void testGetManufacturer() {
        System.out.println("getManufacturer");
        Device instance = new Device();
        String expResult = "";
        String result = instance.getManufacturer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManufacturer method, of class Device.
     */
    @Test
    public void testSetManufacturer() {
        System.out.println("setManufacturer");
        String manufacturer = "";
        Device instance = new Device();
        instance.setManufacturer(manufacturer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModel method, of class Device.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        Device instance = new Device();
        String expResult = "";
        String result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class Device.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        String model = "";
        Device instance = new Device();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateRegistered method, of class Device.
     */
    @Test
    public void testGetDateRegistered() {
        System.out.println("getDateRegistered");
        Device instance = new Device();
        Date expResult = null;
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateRegistered method, of class Device.
     */
    @Test
    public void testSetDateRegistered() {
        System.out.println("setDateRegistered");
        Date dateRegistered = null;
        Device instance = new Device();
        instance.setDateRegistered(dateRegistered);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class Device.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        Device instance = new Device();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToken method, of class Device.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        Device instance = new Device();
        instance.setToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScanresults method, of class Device.
     */
    @Test
    public void testGetScanresults() {
        System.out.println("getScanresults");
        Device instance = new Device();
        Set expResult = null;
        Set result = instance.getScanresults();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScanresults method, of class Device.
     */
    @Test
    public void testSetScanresults() {
        System.out.println("setScanresults");
        Set scanresults = null;
        Device instance = new Device();
        instance.setScanresults(scanresults);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}