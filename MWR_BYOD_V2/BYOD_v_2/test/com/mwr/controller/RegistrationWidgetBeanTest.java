/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Devicenotregistered;
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
public class RegistrationWidgetBeanTest {
    
    public RegistrationWidgetBeanTest() {
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
     * Test of getMessage method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetMessage() {
        System.out.println("getMessage");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        String expResult = "";
        String result = instance.getMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMessage method, of class RegistrationWidgetBean.
     */
    @Test
    public void testSetMessage() {
        System.out.println("setMessage");
        String message = "";
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.setMessage(message);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        String expResult = "";
        String result = instance.getToken();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToken method, of class RegistrationWidgetBean.
     */
    @Test
    public void testSetToken() {
        System.out.println("setToken");
        String token = "";
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.setToken(token);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevice method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.getDevice();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerDevice method, of class RegistrationWidgetBean.
     */
    @Test
    public void testRegisterDevice() {
        System.out.println("registerDevice");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        String expResult = "";
        String result = instance.registerDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBean1 method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetBean1() {
        System.out.println("getBean1");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        DatabaseJSFManagedBean expResult = null;
        DatabaseJSFManagedBean result = instance.getBean1();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBean1 method, of class RegistrationWidgetBean.
     */
    @Test
    public void testSetBean1() {
        System.out.println("setBean1");
        DatabaseJSFManagedBean bean1 = null;
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.setBean1(bean1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpDevice method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetEmpDevice() {
        System.out.println("getEmpDevice");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        Devicenotregistered expResult = null;
        Devicenotregistered result = instance.getEmpDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpDevice method, of class RegistrationWidgetBean.
     */
    @Test
    public void testSetEmpDevice() {
        System.out.println("setEmpDevice");
        Devicenotregistered empDevice = null;
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.setEmpDevice(empDevice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}