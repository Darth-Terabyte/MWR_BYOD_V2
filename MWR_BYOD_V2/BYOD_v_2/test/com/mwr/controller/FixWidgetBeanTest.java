/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Device;
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
public class FixWidgetBeanTest {
    
    public FixWidgetBeanTest() {
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
     * Test of getManagedBean method, of class FixWidgetBean.
     */
    @Test
    public void testGetManagedBean() {
        System.out.println("getManagedBean");
        FixWidgetBean instance = new FixWidgetBean();
        DatabaseJSFManagedBean expResult = null;
        DatabaseJSFManagedBean result = instance.getManagedBean();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setManagedBean method, of class FixWidgetBean.
     */
    @Test
    public void testSetManagedBean() {
        System.out.println("setManagedBean");
        DatabaseJSFManagedBean managedBean = null;
        FixWidgetBean instance = new FixWidgetBean();
        instance.setManagedBean(managedBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fixDevice method, of class FixWidgetBean.
     */
    @Test
    public void testFixDevice() {
        System.out.println("fixDevice");
        FixWidgetBean instance = new FixWidgetBean();
        String expResult = "";
        String result = instance.fixDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevice method, of class FixWidgetBean.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        FixWidgetBean instance = new FixWidgetBean();
        instance.getDevice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessage method, of class FixWidgetBean.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        FixWidgetBean instance = new FixWidgetBean();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class FixWidgetBean.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        FixWidgetBean instance = new FixWidgetBean();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpDevice method, of class FixWidgetBean.
     */
    @Test
    public void testGetEmpDevice() {
        System.out.println("getEmpDevice");
        FixWidgetBean instance = new FixWidgetBean();
        Device expResult = null;
        Device result = instance.getEmpDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpDevice method, of class FixWidgetBean.
     */
    @Test
    public void testSetEmpDevice() {
        System.out.println("setEmpDevice");
        Device empDev = null;
        FixWidgetBean instance = new FixWidgetBean();
        instance.setEmpDevice(empDev);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class FixWidgetBean.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        FixWidgetBean instance = new FixWidgetBean();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToken method, of class FixWidgetBean.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        FixWidgetBean instance = new FixWidgetBean();
        instance.setToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}