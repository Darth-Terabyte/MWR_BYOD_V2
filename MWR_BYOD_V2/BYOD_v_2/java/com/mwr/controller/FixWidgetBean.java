package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.HibernateUtil;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @version 2.0
 * @author LuxInTenebris
 */
@ManagedBean(name = "fix")
@SessionScoped
public class FixWidgetBean implements Serializable {

    private Session session;
    private String message = "";
    private Device empDevice = null;
    private String token;
    @ManagedProperty(value = "#{bean}")
    DatabaseJSFManagedBean managedBean;

    /**
     *
     */
    public FixWidgetBean() {
    }

    /**
     *
     * @return
     */
    public DatabaseJSFManagedBean getManagedBean() {
        return managedBean;
    }

    public void setManagedBean(DatabaseJSFManagedBean managedBean) {
        this.managedBean = managedBean;
    }

    /**
     *
     * @return
     */
    public String fixDevice() {
        try {
            if (empDevice != null) {
                managedBean.setDev(empDevice);
                message = "";
                token = "";
                return "device.xhtml";
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void getDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Device where token = :token");
            //Logger.getLogger(FixWidgetBean.class.getName()).info("from Device where token = " + token);
            query.setParameter("token", token);
            if (query.list().isEmpty()) {
                message = "No registered device with token " + token;
            } else {
                empDevice = (Device) query.list().get(0);
                message = empDevice.getEmployee().getName() + " " + empDevice.getEmployee().getSurname() + ":\n" + empDevice.getManufacturer() + " " + empDevice.getModel();
            }

        } finally {
            session.close();
        }

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
    public Device getEmpDevice() {
        return empDevice;
    }

    /**
     *
     * @param empDev
     */
    public void setEmpDevice(Device empDev) {
        this.empDevice = empDev;
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
}
