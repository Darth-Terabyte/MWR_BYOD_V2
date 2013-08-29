/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import org.hibernate.Session;

/**
 *
 * @author Heindrich
 */
@ManagedBean
@SessionScoped
public class DatabaseJSFManagedBean {

    private Session session;

    /**
     * Creates a new instance of DatabaseJSFManagedBean
     */
    public DatabaseJSFManagedBean() {

        session = HibernateUtil.getSessionFactory().openSession();
    }
}
