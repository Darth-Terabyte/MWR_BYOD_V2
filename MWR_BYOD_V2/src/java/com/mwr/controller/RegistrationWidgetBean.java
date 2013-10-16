package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.DeviceId;
import com.mwr.database.Devicenotregistered;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name = "register")
@SessionScoped
public class RegistrationWidgetBean implements Serializable {

    private Session session;
    private Boolean devExist = false;
    private Boolean empExist = false;
    private Boolean tokenFlag = false;
    private String devExists = "";
    private String empExists = "";
    private String token = " ";
    private String empID;
    private String devID;
    private Employee emp;
    private Devicenotregistered empDev;
    private ArrayList<String> empDevs;
    private List<Devicenotregistered> empDevList;

    public RegistrationWidgetBean() {
        this.empDevs = new ArrayList<String>();
    }

    public void getEmployee() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where empId = :id");
            query.setParameter("id", empID);
            List<Employee> list = query.list();
            emp = list.get(0);

        } catch (Exception e) {
            token = empID + " does not exist";
        }
    }

    public void getNonRegDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where id = :id");
            query.setParameter("id", devID);
            List<Devicenotregistered> list = query.list();
            Devicenotregistered d = list.get(0);
            if (d == null) {
                token = empID + " does not exist";
                return;
            }
            empDev = d;
        } catch (Exception e) {
            token = empID + " does not exist";
        }
    }

    public void regDevice() {
        empExist();
        devExist();

        if (devExist && empExist && tokenFlag) {
            try {
                DeviceId id = new DeviceId(empDev.getId());
                Device dev = new Device(id, emp, empDev.getManufacturer(), empDev.getModel(), new Date(), empDev.getToken());
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
        } else {
            token = "Not possible";
        }

    }

    public void getEmployeeUnregDevices() {
        if (emp == null) {
        } else {
            try {

                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("from Devicenotregistered where idnumber = :id");
                query.setParameter("id", emp.getIdnumber());
                List<Devicenotregistered> list = query.list();
                if (!list.isEmpty()) {
                    empDevList = list;
                } else {
                    token = "Not possible";
                }
            } finally {
                session.close();
            }

            for (int i = 0; i < empDevList.size(); i++) {
                empDevs.add(empDevList.get(i).getManufacturer() + " " + empDevList.get(i).getModel());
            }
        }
    }

    public void empExist() {
        getEmployee();
        if (emp == null) {
            empExist = false;
            empExists = empID + " does not exist!";

        } else {
            empExist = true;
            empExists = "Valid!";
        }
    }

    public void devExist() {
        getNonRegDevice();
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

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Devicenotregistered getEmpDev() {
        return empDev;
    }

    public void setEmpDev(Devicenotregistered empDev) {
        this.empDev = empDev;
    }

    public List<Devicenotregistered> getEmpDevList() {
        return empDevList;
    }

    public void setEmpDevList(List<Devicenotregistered> empDevList) {
        this.empDevList = empDevList;
    }

    public ArrayList<String> getEmpDevs() {
        return empDevs;
    }

    public void setEmpDevs(ArrayList<String> empDevs) {
        this.empDevs = empDevs;
    }

    public void getDevToken() {
        empExist();
        devExist();

        if (empExist == false) {
            token = empExists;
            tokenFlag = false;
            return;
        }
        if (devExist == false) {
            token = devExists;
            tokenFlag = false;
            return;
        }

        token = empDev.getToken();
        tokenFlag = true;
    }
}
