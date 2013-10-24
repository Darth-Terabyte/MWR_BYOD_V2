/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.Employee;
import com.mwr.database.Scanresult;
import com.mwr.database.Blacklistedapp;
import java.sql.Timestamp;
import java.util.Date;
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
public class DatabaseJSFManagedBeanTest {
    
    public DatabaseJSFManagedBeanTest() {
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
     * Test of deviceRegistered method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testDeviceRegistered() {
        System.out.println("deviceRegistered: existing mac, androidID and serial number");
        String mac = "2222";
        String serial = "4444";
        String androidID = "3333";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = true;
        boolean result = instance.deviceRegistered(mac, serial, androidID);
        assertEquals(expResult, result);
        
        System.out.println("deviceRegistered: nonexisting mac, androidID and serial number");
        mac = "123";
        serial = "12341234";
        androidID = "12341234";
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.deviceRegistered(mac, serial, androidID);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of deviceWaiting method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testDeviceWaiting() {
        System.out.println("deviceWaiting: existing mac, androidID and serial number");
        String mac = "mac";
        String serial = "serialnumber";
        String androidID = "androidid";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = true;
        boolean result = instance.deviceWaiting(mac, serial, androidID);
        assertEquals(expResult, result);
        
        System.out.println("deviceWaiting: nonexisting mac, androidID and serial number");
        mac = "mac";
        serial = "1234";
        androidID = "androidid";
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.deviceWaiting(mac, serial, androidID);
        assertEquals(expResult, result);
        
        System.out.println("deviceWaiting: null values");
        mac = null;
        serial = null;
        androidID = null;
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.deviceWaiting(mac, serial, androidID);
        assertEquals(expResult, result);
    }

    /**
     * Test of addToWaitingList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testAddToWaitingList() throws Exception {
       System.out.println("addToWaitingList: null strings");
        String mac = null;
        String android = null;
        String serial = null;
        String manufacturer = null;
        String model = null;
        String username = null;
        String password = null;
        String idnumber = null;
        String name = null;
        String surname = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        instance.addToWaitingList(mac, android, serial, manufacturer, model, username, password, idnumber, name, surname);
        boolean result = instance.deviceWaiting(mac, serial, android);
        boolean expResult = false;
        assertEquals(result,expResult);
        
        System.out.println("addToWaitingList: empty strings");
        mac = "";
        android = "";
        serial = "";
        manufacturer = "";
        model = "";
        username = "";
        password = "";
        idnumber = "";
        name = "";
        surname = "";
        instance = new DatabaseJSFManagedBean();
        instance.addToWaitingList(mac, android, serial, manufacturer, model, username, password, idnumber, name, surname);
        result = instance.deviceWaiting(mac, serial, android);
        expResult = false;
        assertEquals(result,expResult);
        
        System.out.println("addToWaitingList: non-empty strings");
        mac = "abcd";
        android = "abcd";
        serial = "abcd";
        manufacturer = "samsung";
        model = "galaxy";
        username = "john";
        password = "password";
        idnumber = "12345";
        name = "john";
        surname = "green";
        instance = new DatabaseJSFManagedBean();
        instance.addToWaitingList(mac, android, serial, manufacturer, model, username, password, idnumber, name, surname);
        result = instance.deviceWaiting(mac, serial, android);
        expResult = true;
        assertEquals(result,expResult);
        
  
        
        
    }
    
    /**
     * Test of employeeRegistered method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testEmployeeRegistered() {
        System.out.println("employeeRegistered: existing employee");
        int id = 1;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = true;
        boolean result = instance.employeeRegistered(id);
        assertEquals(expResult, result);
        
        System.out.println("employeeRegistered: existing employee");
        id = 5;
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.employeeRegistered(id);
        assertEquals(expResult, result);       
        

    }

    /**
     * Test of addEmployee method, of class DatabaseJSFManagedBean.
     */
//    @Test
//    public void testAddEmployee() {
//        System.out.println("addEmployee");
//        String username = "jan";
//        String password = "password";
//        String name = "jan";
//        String surname = "van der merwe";
//        String idnumber = "123455";
//        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
//        int oldsize = instance.getEmployeeList().size();
//        Employee employee = instance.addEmployee(username, password, name, surname, idnumber);
//        int newsize = instance.getEmployeeList().size();
//        assertEquals(oldsize, newsize);
//        
//        System.out.println("addEmployee: already registered");
//        username = "jan";
//        password = "password";
//        name = "jan";
//        surname = "van der merwe";
//        idnumber = "123456";
//        instance = new DatabaseJSFManagedBean();
//        oldsize = instance.getEmployeeList().size();
//        employee = instance.addEmployee(username, password, name, surname, idnumber);
//        newsize = instance.getEmployeeList().size();
//        assertEquals(oldsize, newsize);
//        
//         
//        System.out.println("addEmployee: empty strings");
//        username = "jan";
//        password = "password";
//        name = "mark";
//        surname = "twain";
//        idnumber = "123455";
//        instance = new DatabaseJSFManagedBean();
//        oldsize = instance.getEmployeeList().size();
//        employee = instance.addEmployee(username, password, name, surname, idnumber);
//        newsize = instance.getEmployeeList().size();
//        assertEquals(oldsize, newsize);
//        
//        System.out.println("addEmployee: empty strings");
//        username = "jan";
//        password = "password";
//        name = "mark";
//        surname = "twain";
//        idnumber = "123455";
//        instance = new DatabaseJSFManagedBean();
//        oldsize = instance.getEmployeeList().size();
//        employee = instance.addEmployee(username, password, name, surname, idnumber);
//        newsize = instance.getEmployeeList().size();
//        assertEquals(oldsize, newsize-1);
//
//    }

    /**
     * Test of viewEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testViewEmployee() {
        System.out.println("viewEmployee: null");
        Employee emp = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "users.xhtml";
        String result = instance.viewEmployee(emp);
        assertEquals(expResult, result);

        System.out.println("viewEmployee: not null");
        emp = new Employee();
        instance = new DatabaseJSFManagedBean();
        expResult = "user.xhtml";
        result = instance.viewEmployee(emp);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of getWaitingList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetWaitingList_String() {
        System.out.println("getWaitingList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List result = instance.getWaitingList();
        assert(result.size() > 0);
    }

    /**
     * Test of getDeviceList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDeviceList() {
        System.out.println("getDeviceList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List result = instance.getDeviceList();
        assert(result.size() > 0);
    }

    /**
     * Test of getEmployeeList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetEmployeeList() {
        System.out.println("getEmployeeList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List result = instance.getEmployeeList();
        assert(result.size() > 0);
    }

    /**
     * Test of getApps method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetApps() {
        System.out.println("getApps");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "Facebook";
        List apps = instance.getApps();       
        assertEquals(1,apps.size());
        Blacklistedapp app = (Blacklistedapp) apps.get(0);
        assertEquals(expResult, app.getAppName());
    }



   

    /**
     * Test of removeEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Employee emp = instance.addEmployee("username","password", "name", "surname", "1234");
        int id = emp.getEmpId();
        
        String result = instance.removeEmployee(emp);
        boolean actual = instance.employeeRegistered(id);
        assertEquals(false, actual);
    }


    /**
     * Test of getToken method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        String mac = "12341234";
        String androidID = "12341234";
        String serial = "12341234";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "sadsa";
        String result = instance.getToken(mac, androidID, serial);
        assertEquals(expResult, result);
        
   }

    /**
     * Test of login method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "wern";
        String password = "1a1dc91c907325c69271ddf0c944bc72";
        String mac = "12341234";
        String androidID = "12341234";
        String serial = "12341234";
        String ip = "333.333.333.333";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = true;
        boolean result = instance.login(username, password, mac, androidID, serial, ip);
        assertEquals(expResult, result);
        
        System.out.println("login");
        username = "wern";
        password = "wrongpassword";
        mac = "12341234";
        androidID = "12341234";
        serial = "12341234";
        ip = "333.333.333.333";
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.login(username, password, mac, androidID, serial, ip);
        assertEquals(expResult, result);
        
        System.out.println("login");
        username = "wern";
        password = "1a1dc91c907325c69271ddf0c944bc72";
        mac = "3333";
        androidID = "12341234";
        serial = "12341234";
        ip = "333.333.333.333";
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.login(username, password, mac, androidID, serial, ip);
        assertEquals(expResult, result);
    }

    /**
     * Test of isActiveUser method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testIsActiveUser() {
        System.out.println("isActiveUser");
        String ip = "222.222.222.222";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = true;
        boolean result = instance.isActiveUser(ip);
        assertEquals(expResult, result);

        System.out.println("isActiveUser");
        ip = "123.123.123.123";
        instance = new DatabaseJSFManagedBean();
        expResult = false;
        result = instance.isActiveUser(ip);
        assertEquals(expResult, result);
        
        
    }

}