/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.DeviceId;
import com.mwr.database.Devicenotregistered;
import com.mwr.database.Employee;
import com.mwr.database.Scanresult;
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
        System.out.println("deviceRegistered");
        String mac = "";
        String serial = "";
        String androidID = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = false;
        boolean result = instance.deviceRegistered(mac, serial, androidID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deviceWaiting method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testDeviceWaiting() {
        System.out.println("deviceWaiting");
        String mac = "";
        String serial = "";
        String androidID = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = false;
        boolean result = instance.deviceWaiting(mac, serial, androidID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToWaitingList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testAddToWaitingList() throws Exception {
        System.out.println("addToWaitingList");
        String mac = "";
        String android = "";
        String serial = "";
        String manufacturer = "";
        String model = "";
        String username = "";
        String password = "";
        String idnumber = "";
        String name = "";
        String surname = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        instance.addToWaitingList(mac, android, serial, manufacturer, model, username, password, idnumber, name, surname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testAddEmployee() {
        System.out.println("addEmployee");
        String username = "";
        String password = "";
        String name = "";
        String surname = "";
        String idnumber = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Employee expResult = null;
        Employee result = instance.addEmployee(username, password, name, surname, idnumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testViewEmployee() {
        System.out.println("viewEmployee");
        Employee emp = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "";
        String result = instance.viewEmployee(emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDevice method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testAddDevice() {
        System.out.println("addDevice");
        Devicenotregistered deviceNotRegistered = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        instance.addDevice(deviceNotRegistered);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetEmployee() {
        System.out.println("getEmployee");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Employee expResult = null;
        Employee result = instance.getEmployee();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWaitingList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetWaitingList_0args() {
        System.out.println("getWaitingList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getWaitingList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWaitingList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetWaitingList_String() {
        System.out.println("getWaitingList");
        String id = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getWaitingList(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDeviceList() {
        System.out.println("getDeviceList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getDeviceList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeList method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetEmployeeList() {
        System.out.println("getEmployeeList");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getEmployeeList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApps method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetApps() {
        System.out.println("getApps");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getApps();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatestSetting method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetLatestSetting() {
        System.out.println("getLatestSetting");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Setting expResult = null;
        Setting result = instance.getLatestSetting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addScanResults method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testAddScanResults() {
        System.out.println("addScanResults");
        String mac = "";
        String serial = "";
        String androidID = "";
        boolean rooted = false;
        boolean debug = false;
        boolean unknown = false;
        String installedApps = "";
        int api = 0;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = false;
        boolean result = instance.addScanResults(mac, serial, androidID, rooted, debug, unknown, installedApps, api);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmployeeDevices method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetEmployeeDevices() {
        System.out.println("getEmployeeDevices");
        int id = 0;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getEmployeeDevices(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDevice method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testSetDevice() {
        System.out.println("setDevice");
        DeviceId id = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "";
        String result = instance.setDevice(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDev method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testSetDev() {
        System.out.println("setDev");
        Device dev = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        instance.setDev(dev);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevice_Results method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDevice_Results() {
        System.out.println("getDevice_Results");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        List expResult = null;
        List result = instance.getDevice_Results();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDeviceSize method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDeviceSize() {
        System.out.println("getDeviceSize");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        int expResult = 0;
        int result = instance.getDeviceSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDevice method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDevice() {
        System.out.println("getDevice");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Device expResult = null;
        Device result = instance.getDevice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQueueSize method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetQueueSize() {
        System.out.println("getQueueSize");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        int expResult = 0;
        int result = instance.getQueueSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllowed method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetAllowed() {
        System.out.println("getAllowed");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        int expResult = 0;
        int result = instance.getAllowed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDenied method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetDenied() {
        System.out.println("getDenied");
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        int expResult = 0;
        int result = instance.getDenied();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDevice method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testRemoveDevice() {
        System.out.println("removeDevice");
        Device device = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "";
        String result = instance.removeDevice(device);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeEmployee method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testRemoveEmployee() {
        System.out.println("removeEmployee");
        Employee emp = null;
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "";
        String result = instance.removeEmployee(emp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLatestScan method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetLatestScan() {
        System.out.println("getLatestScan");
        String mac = "";
        String serial = "";
        String androidID = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        Scanresult expResult = null;
        Scanresult result = instance.getLatestScan(mac, serial, androidID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getToken method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testGetToken() {
        System.out.println("getToken");
        String mac = "";
        String androidID = "";
        String serial = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        String expResult = "";
        String result = instance.getToken(mac, androidID, serial);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of login method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        String mac = "";
        String androidID = "";
        String serial = "";
        String ip = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = false;
        boolean result = instance.login(username, password, mac, androidID, serial, ip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActiveUser method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testIsActiveUser() {
        System.out.println("isActiveUser");
        String ip = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        boolean expResult = false;
        boolean result = instance.isActiveUser(ip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class DatabaseJSFManagedBean.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        String mac = "";
        String androidID = "";
        String serial = "";
        String remoteAddr = "";
        DatabaseJSFManagedBean instance = new DatabaseJSFManagedBean();
        instance.logout(mac, androidID, serial, remoteAddr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}