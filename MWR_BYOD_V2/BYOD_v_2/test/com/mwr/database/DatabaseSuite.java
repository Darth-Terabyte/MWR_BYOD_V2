/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author madenem
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({com.mwr.database.DeviceIdTest.class, com.mwr.database.DevicenotregisteredIdTest.class, com.mwr.database.DevicenotregisteredTest.class, com.mwr.database.SettingTest.class, com.mwr.database.DeviceTest.class, com.mwr.database.BlacklistedappTest.class, com.mwr.database.ActiveuserTest.class, com.mwr.database.ScanresultTest.class, com.mwr.database.HibernateUtilTest.class, com.mwr.database.EmployeeTest.class})
public class DatabaseSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}