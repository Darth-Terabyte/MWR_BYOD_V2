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
     * Test of getDevice method, of class FixWidgetBean.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        FixWidgetBean instance = new FixWidgetBean();
        instance.setToken("sadsa");
        instance.getDevice();
        Device empDevice = instance.getEmpDevice();
        String mac = empDevice.getId().getMacaddress();
        assertEquals("12341234",mac);
        String serial = empDevice.getId().getSerialNumber();
        assertEquals("12341234",serial);
        String androidID = empDevice.getId().getAndroidId();
        assertEquals("12341234",androidID);        
        
        System.out.println("getDevice");
        instance = new FixWidgetBean();
        instance.setToken("asdf");
        instance.getDevice();
        String message = instance.getMessage();
        assertEquals("No registered device with token asdf",message);
        
    }

    
}