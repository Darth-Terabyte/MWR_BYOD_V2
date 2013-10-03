package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.DeviceId;
import com.mwr.database.Devicenotregistered;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;

@ManagedBean(name = "fix")
@SessionScoped
public class FixWidgetBean implements Serializable{

    private org.hibernate.Session session;
    private Boolean devExist = false;
    private Boolean empExist = false;
    private String devExists = "";
    private String empExists = "";
    private String display = " ";
    private String empID;
    private String devID;
    private Employee emp;
    private Device empDev;

    public Employee getEmployee() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where empId = :id");
            query.setParameter("id", empID);
            List<Employee> list = query.list();
            Employee e = list.get(0);
            if (e == null) {
                return null;
            } else {
                return e;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public String fixDevice() {
        empExist();
        devExist();
        if (devExist && empExist) {
            try {
                display = "";
                DatabaseJSFManagedBean b = new DatabaseJSFManagedBean();
                b.setDevice(empDev);                
                return "device.xhtml";
            } finally {
                session.close();
            }
        } else {
            display = "Not possible";
        }
        return "home.xhtml";
    }

    public List<Devicenotregistered> getEmployeeUnregDevices() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where id = :id");
            query.setParameter("id", emp.getIdnumber());
            List<Devicenotregistered> list = query.list();
            return list;
        } finally {
            session.close();
        }
    }

    public Device getDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Device where id = :id");
            query.setParameter("id", devID);
            List<Device> list = query.list();
            Device d = list.get(0);
            if (d == null) {
                return null;
            } else {
                return d;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void empExist() {
        emp = getEmployee();
        if (emp == null) {
            empExist = false;
            if (empID.isEmpty()) {
                empExists = "Empty field!";
            } else {
                empExists = empID + " does not exist!";
            }

        } else {
            empExist = true;
            empExists = "Valid!";
        }
    }

    public void devExist() {
        empDev = getDevice();
        if (empDev == null) {
            devExist = false;
            if (devID.isEmpty()) {
                devExists = "Empty field!";
            } else {
                devExists = devID + " does not exist!";
            }

        } else {
            devExist = true;
            devExists = "Valid!";
        }
    }

    public Boolean getDevExist() {
        return devExist;
    }

    public void setDevExist(Boolean devExist) {
        this.devExist = devExist;
    }

    public Boolean getEmpExist() {
        return empExist;
    }

    public void setEmpExist(Boolean empExist) {
        this.empExist = empExist;
    }

    public String getDevExists() {
        return devExists;
    }

    public void setDevExists(String devExists) {
        this.devExists = devExists;
    }

    public String getEmpExists() {
        return empExists;
    }

    public void setEmpExists(String empExists) {
        this.empExists = empExists;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getDevID() {
        return devID;
    }

    public void setDevID(String devID) {
        this.devID = devID;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
