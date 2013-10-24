/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Device;
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
     * Test of getDevice method, of class RegistrationWidgetBean.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        RegistrationWidgetBean instance = new RegistrationWidgetBean();
        instance.setToken("1234");
        instance.getDevice();
        Devicenotregistered empDevice = instance.getEmpDevice();
        String mac = empDevice.getId().getMacaddress();
        assertEquals("mac",mac);
        String serial = empDevice.getId().getSerialNumber();
        assertEquals("serialnumber",serial);
        String androidID = empDevice.getId().getAndroidId();
        assertEquals("androidid",androidID);
        
        System.out.println("getDevice");
        instance = new RegistrationWidgetBean();
        instance.setToken("asdf");
        instance.getDevice();
        String message = instance.getMessage();
        assertEquals("No device in waiting list with token asdf",message);
    }



    
}