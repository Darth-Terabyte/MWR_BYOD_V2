package com.mwr.controller;

import com.mwr.database.Devicenotregistered;
import com.mwr.database.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @version 2.0
 * @author LuxInTenebris
 */
@ManagedBean(name = "register")
@SessionScoped
public class RegistrationWidgetBean implements Serializable {

    private Session session;
    private String token = "";
    private String message = "";
    private Devicenotregistered empDevice;
    @ManagedProperty(value = "#{bean}")
    DatabaseJSFManagedBean bean1;

    /**
     * Getter for the employee based on its id. The id is saved by our bean as
     * empID.
     *
     */
    public RegistrationWidgetBean() {
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        String msg = message;
        message = "";
        return msg;
    }

    /**
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     *
     * @return
     */
    public String getToken() {
        String msg = token;
        token = "";
        return msg;
    }

    /**
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     *
     */
    public void getDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where token = :token");
            Logger.getLogger(RegistrationWidgetBean.class.getName()).log(Level.INFO, "from Device where token = {0}", token);
            query.setParameter("token", token);
            if (query.list().isEmpty()) {
                message = "No device in waiting list with token " + token;
            } else {
                empDevice = (Devicenotregistered) query.list().get(0);
                message = empDevice.getManufacturer() + " " + empDevice.getModel() + " found";
            }

        } finally {
            session.close();
        }

    }

    /**
     *
     * @return
     */
    public String registerDevice() {
        if (empDevice != null) {
            bean1.addDevice(empDevice);
            message = "Device registered";
        }
        message = "";
        token = "";
        return "#";

    }

    /**
     *
     * @return
     */
    public DatabaseJSFManagedBean getBean1() {
        return bean1;
    }

    /**
     *
     * @param bean1
     */
    public void setBean1(DatabaseJSFManagedBean bean1) {
        this.bean1 = bean1;
    }

    public Devicenotregistered getEmpDevice() {
        return empDevice;
    }

    public void setEmpDevice(Devicenotregistered empDevice) {
        this.empDevice = empDevice;
    }
}
