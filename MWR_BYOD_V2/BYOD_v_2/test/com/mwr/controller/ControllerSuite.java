/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

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
@Suite.SuiteClasses({com.mwr.controller.SettingsBeanTest.class, com.mwr.controller.DatabaseJSFManagedBeanTest.class, com.mwr.controller.RegistrationWidgetBeanTest.class, com.mwr.controller.FixWidgetBeanTest.class})
public class ControllerSuite {

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