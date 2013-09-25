package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.DeviceId;
import com.mwr.database.Devicenotregistered;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name = "register")
@SessionScoped
public class RegistrationWidgetBean {

    private Session session;
    private Boolean devExist = false;
    private Boolean empExist = false;
    private String devExists = "";
    private String empExists = "";
    private String token = " ";
    private String empID;
    private String devID;
    private Employee emp;
    private Devicenotregistered empDev;

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

    public void regDevice() {
        empExist();
        devExist();
        
        if (devExist && empExist)
        try {            
            DeviceId id = new DeviceId(empDev.getId());
            Device dev = new Device(id, emp, empDev.getManufacturer(), empDev.getModel(), new Date(),empDev.getToken());
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dev);
            session.getTransaction().commit();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(empDev);
            session.getTransaction().commit();
            token = "";

        } finally {
            session.close();
        }
        else token = "Not possible";

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
    public Devicenotregistered getNonRegDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where id = :id");
            query.setParameter("id", devID);
            List<Devicenotregistered> list = query.list();
            Devicenotregistered d = list.get(0);
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
            empExists = empID + " does not exist!";

        } else {
            empExist = true;
            empExists = "Valid!";
        }
    }

    public void devExist() {
        empDev = getNonRegDevice();
        if (empDev == null) {
            devExist = false;
            devExists = devID + " does not exist!";

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void getDevToken()
    {
        empExist();
        devExist();
        
        if (empExist == false) {
            token = empExists;
            return;
        }
        if (devExist == false) {
            token = devExists;
            return;
        }

        token = empDev.getToken();
    }
}
