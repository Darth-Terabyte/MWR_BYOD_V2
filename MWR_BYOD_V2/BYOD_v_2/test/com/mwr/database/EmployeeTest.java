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
public class EmployeeTest {
    
    public EmployeeTest() {
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
     * Test of getEmpId method, of class Employee.
     */
    @Test
    public void testGetEmpId() {
        System.out.println("getEmpId");
        Employee instance = new Employee();
        Integer expResult = null;
        Integer result = instance.getEmpId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmpId method, of class Employee.
     */
    @Test
    public void testSetEmpId() {
        System.out.println("setEmpId");
        Integer empId = null;
        Employee instance = new Employee();
        instance.setEmpId(empId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Employee.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Employee.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Employee instance = new Employee();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Employee.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Employee.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Employee instance = new Employee();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateRegistered method, of class Employee.
     */
    @Test
    public void testGetDateRegistered() {
        System.out.println("getDateRegistered");
        Employee instance = new Employee();
        Date expResult = null;
        Date result = instance.getDateRegistered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDateRegistered method, of class Employee.
     */
    @Test
    public void testSetDateRegistered() {
        System.out.println("setDateRegistered");
        Date dateRegistered = null;
        Employee instance = new Employee();
        instance.setDateRegistered(dateRegistered);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Employee.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Employee instance = new Employee();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSurname method, of class Employee.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getSurname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSurname method, of class Employee.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String surname = "";
        Employee instance = new Employee();
        instance.setSurname(surname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIdnumber method, of class Employee.
     */
    @Test
    public void testGetIdnumber() {
        System.out.println("getIdnumber");
        Employee instance = new Employee();
        String expResult = "";
        String result = instance.getIdnumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdnumber method, of class Employee.
     */
    @Test
    public void testSetIdnumber() {
        System.out.println("setIdnumber");
        String idnumber = "";
        Employee instance = new Employee();
        instance.setIdnumber(idnumber);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevices method, of class Employee.
     */
    @Test
    public void testGetDevices() {
        System.out.println("getDevices");
        Employee instance = new Employee();
        Set expResult = null;
        Set result = instance.getDevices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDevices method, of class Employee.
     */
    @Test
    public void testSetDevices() {
        System.out.println("setDevices");
        Set devices = null;
        Employee instance = new Employee();
        instance.setDevices(devices);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}