package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.classic.Session;

@ManagedBean(name = "validation")
@SessionScoped
public class ValidationBean {

    private Boolean devExist = false;
    private Boolean empExist = false;
    private String devExists = "";
    private String empExists = "";
    private String token = "";
    private String empID;
    private String devID;
    private Employee emp;
    private Device empDev;
    private DatabaseJSFManagedBean d;

    public String empExist() {
        emp = d.getEmployee(empID);
        if (emp == null) {
            empExist = false;
            empExists = empID + " does not exist!";

        } else {
            empExist = true;
            empExists = "Valid!";
        }
        return empExists;
    }

    public String devExist() {
        empDev = d.getDevice(devID);
        if (empDev == null) {
            devExist = false;
            devExists = devID + " does not exist!";

        } else {
            devExist = true;
            devExists = "Valid!";
        }
        return devExists;
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
    
    public String getDevToken()
    {
        if (empExist == false)
            return empExists;
        if (devExist == false)
            return devExists;
        
        return empDev.getToken();
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
