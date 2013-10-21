package com.mwr.controller;

import com.mwr.database.Device;
import com.mwr.database.DeviceId;
import com.mwr.database.Devicenotregistered;
import com.mwr.database.Employee;
import com.mwr.database.HibernateUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author madenem
 */
@ManagedBean(name = "register")
@SessionScoped
public class RegistrationWidgetBean implements Serializable {

    private Session session;
    private Boolean devExist = false;
    private Boolean empExist = false;
    private Boolean tokenFlag = false;
    private String devExists = "";
    private String empExists = "";
    private String token = "";
    private String message = "";
    private String empMakeMod = "";
    private String empID = null;
    private String devID = null;
    private Employee emp = null;
    private Devicenotregistered empDev = null;
    private List<Devicenotregistered> empDevList = null;
    private Devicenotregistered empDevice;
    @ManagedProperty(value = "#{bean}")
    DatabaseJSFManagedBean bean1;

    /**
     *
     */
    public RegistrationWidgetBean() {
    }

    /**
     *
     */
    public void getEmployee() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where empId = :id");
            query.setParameter("id", Integer.parseInt(empID));
            List<Employee> list = query.list();
            emp = list.get(0);

        } catch (Exception e) {
            message = empID + " does not exist";
        }
    }

    /**
     *
     */
    public void getNonRegDevice() {
        try {

            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where id = :id");
            query.setParameter("id", devID);
            List<Devicenotregistered> list = query.list();
            Devicenotregistered d = list.get(0);
            if (d == null) {
                message = empID + " does not exist";
                return;
            }
            empDev = d;
        } catch (Exception e) {
            message = empID + " does not exist";
        }
    }

    /**
     *
     */
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
                message = "Registered!";

            } finally {
                session.close();
            }
        } else {
            message = "Not possible";
        }

    }

    /**
     *
     */
    public void getEmployeeUnregDevices() {
        emp = null;
        getEmployee();

        if (emp == null) {
            System.out.println("No employee");
        } else {
            try {
                session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query query = session.createQuery("from Devicenotregistered where idnumber = :id");
                query.setParameter("id", emp.getIdnumber());
                List<Devicenotregistered> list = query.list();
                if (list.isEmpty()) {
                    message = empID + " has no unregistered devices.";
                } else {
                    message = "";
                    empDevList = list;
                }
            } finally {
                session.close();
            }
        }
    }

    /**
     *
     */
    public void empExist() {
        getEmployee();
        if (emp == null) {
            empExist = false;
            empExists = empID + " does not exist!";

        } else {
            empExist = true;
            empExists = "";
        }
    }

    /**
     *
     * @param v
     */
    public void showDev(Devicenotregistered v) {
        System.out.println("Device: " + v);
    }

    /**
     *
     */
    public void devExist() {

        if (empDev == null) {
            devExist = false;
            devExists = devID + " does not exist!";

        } else {
            devExist = true;
            devExists = "";
        }
    }

    /**
     *
     * @return
     */
    public String getMessage() {
        return message;
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
    public Boolean getDevExist() {
        return devExist;
    }

    /**
     *
     * @param devExist
     */
    public void setDevExist(Boolean devExist) {
        this.devExist = devExist;
    }

    /**
     *
     * @return
     */
    public Boolean getEmpExist() {
        return empExist;
    }

    /**
     *
     * @param empExist
     */
    public void setEmpExist(Boolean empExist) {
        this.empExist = empExist;
    }

    /**
     *
     * @return
     */
    public Boolean getTokenFlag() {
        return tokenFlag;
    }

    /**
     *
     * @param tokenFlag
     */
    public void setTokenFlag(Boolean tokenFlag) {
        this.tokenFlag = tokenFlag;
    }

    /**
     *
     * @return
     */
    public String getDevExists() {
        return devExists;
    }

    /**
     *
     * @return
     */
    public String getEmpMakeMod() {
        return empMakeMod;
    }

    /**
     *
     * @param empMakeMod
     */
    public void setEmpMakeMod(String empMakeMod) {
        this.empMakeMod = empMakeMod;
    }

    /**
     *
     * @param devExists
     */
    public void setDevExists(String devExists) {
        this.devExists = devExists;
    }

    /**
     *
     * @return
     */
    public String getEmpExists() {
        return empExists;
    }

    /**
     *
     * @param empExists
     */
    public void setEmpExists(String empExists) {
        this.empExists = empExists;
    }

    /**
     *
     * @return
     */
    public String getEmpID() {
        return empID;
    }

    /**
     *
     * @param empID
     */
    public void setEmpID(String empID) {
        this.empID = empID;
    }

    /**
     *
     * @return
     */
    public String getDevID() {
        return devID;
    }

    /**
     *
     * @param devID
     */
    public void setDevID(String devID) {
        this.devID = devID;
    }

    /**
     *
     * @return
     */
    public String getToken() {
        return token;
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
     * @return
     */
    public Employee getEmp() {
        return emp;
    }

    /**
     *
     * @param emp
     */
    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    /**
     *
     * @return
     */
    public Devicenotregistered getEmpDev() {
        return empDev;
    }

    /**
     *
     * @param empDev
     */
    public void setEmpDev(Devicenotregistered empDev) {
        this.empDev = empDev;
    }

    /**
     *
     * @return
     */
    public List<Devicenotregistered> getEmpDevList() {
        return empDevList;
    }

    /**
     *
     * @param empDevList
     */
    public void setEmpDevList(List<Devicenotregistered> empDevList) {
        this.empDevList = empDevList;
    }

    /**
     *
     */
    public void getDevToken() {
        empExist();
        devExist();

        tokenFlag = false;
        if (empExist == false) {
            message = emp.getEmpId() + "That user does not exist!";
            tokenFlag = false;
            return;
        }
        if (devExist == false) {
            message = "That device does not exist!";
            tokenFlag = false;
            return;
        }
        tokenFlag = true;
        token = empDev.getToken();
        message = token;
        System.out.println("Token: " + token);
    }

    /**
     *
     * @return
     */
    public Devicenotregistered getEmpDevice() {
        return empDevice;
    }

    /**
     *
     * @param empDevice
     */
    public void setEmpDevice(Devicenotregistered empDevice) {
        this.empDevice = empDevice;
    }

    /**
     *
     */
    public void getDevice() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where token = :token");
            Logger.getLogger(RegistrationWidgetBean.class.getName()).info("from Device where token = " + token);
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
        }
        message = "";
        return "#";

//        empExist();
//        devExist();
//
//        if (devExist && empExist) {
//            try {
//            } catch (Exception e) {
//                message = "Not possible";
//            }
//        } else {
//            message = "Not possible";
//        }
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
}
