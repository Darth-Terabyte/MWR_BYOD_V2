/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import com.mwr.businesslogic.TokenGenerator;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @version 2.0
 * @author LuxInTenebris
 */
@ManagedBean(name = "bean")
@SessionScoped
public class DatabaseJSFManagedBean implements Serializable {

    private Session session;
    private Employee employee;
    private Device device;
    private Devicenotregistered device_not;
    private List<Devicenotregistered> waitingList;
    private List<Device> deviceList;
    private List<Employee> employeeList;
    private Setting latestSetting;
    private List<Blacklistedapp> apps;
    private Scanresult results;
    private List<Scanresult> device_results;
    private int allowed;
    private int denied;
    private int rootedWeight;
    private int debugWeight;
    private int unknownSourcesWeight;
    private int osWeight;
    private int lowRiskApp;
    private int mediumRiskApp;
    private int highRiskApp;
    private int blockedApp;
    private int accessScore;
    private List<Device> employeeDevices;

    /**
     *
     */
    public DatabaseJSFManagedBean() {
        session = HibernateUtil.getSessionFactory().openSession();

    }

    /**
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @return Returns true if device is registered
     */
    public boolean deviceRegistered(String mac, String serial, String androidID) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where MACAddress = :mac and AndroidID = :androidid and SerialNumber = :serial");
        query.setParameter("mac", mac);
        query.setParameter("serial", serial);
        query.setParameter("androidid", androidID);
        List<Device> devices = query.list();
        boolean empty = devices.isEmpty();
        session.close();
        return !empty;
    }

    /**
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @return Returns true if device is on registration waiting list
     */
    public boolean deviceWaiting(String mac, String serial, String androidID) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Devicenotregistered where MACAddress = :mac and AndroidID = :androidid and SerialNumber = :serial");
        query.setParameter("mac", mac);
        query.setParameter("serial", serial);
        query.setParameter("androidid", androidID);
        List<Device> devices = query.list();
        boolean empty = devices.isEmpty();
        session.close();
        return !empty;
    }

    /**
     * Add a device to the registration waiting list
     *
     * @param mac Device's MAC Address
     * @param android Device's androidID
     * @param serial Device's serial number
     * @param manufacturer Device's manufacturer
     * @param model Device's model
     * @param username Employee's username
     * @param password Employee's password
     * @param idnumber Employee's ID number
     * @param name Employee's name
     * @param surname Employee's surname
     * @throws NoSuchAlgorithmException
     *
     */
    public void addToWaitingList(String mac, String android, String serial, String manufacturer, String model, String username, String password, String idnumber, String name, String surname) throws NoSuchAlgorithmException {
        try {
            TokenGenerator gen = new TokenGenerator();
            String token = gen.generateToken(mac, android, serial, password);
            //Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(password);
            //Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(token);
            DevicenotregisteredId devicePK = new DevicenotregisteredId(mac, android, serial);
            device_not = new Devicenotregistered(devicePK, manufacturer, model, new Date(), token, username, password, idnumber, name, surname);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(device_not);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    /**
     *
     * @param username Employee's username
     * @param password Employee's password
     * @param idnumber Employee's ID number
     * @param name Employee's name
     * @param surname Employee's surname
     * @return Return registered employee
     */
    public Employee addEmployee(String username, String password, String name, String surname, String idnumber) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where (username = :username and password = :password) and ((name = :name and surname = :surname) or idnumber = :id)");
            query.setParameter("username", username);
            query.setParameter("password", password);
            query.setParameter("name", name);
            query.setParameter("surname", surname);
            query.setParameter("id", idnumber);
            if (query.list().isEmpty()) {
                employee = new Employee(username, password, new Date(), name, surname, idnumber);
                session.save(employee);
                session.getTransaction().commit();
            } else {
                employee = (Employee) query.list().get(0);
            }
        } finally {
            session.close();
            // System.out.println("Employee " + employee.getIdnumber() + " " + employee.getSurname() + " added");
            return employee;
        }

    }

    /**
     *
     * @param emp Employee
     * @return Returns a link to employee's profile that matches id
     */
    public String viewEmployee(Employee emp) {
        employee = emp;
        return "user.xhtml";

    }

    /**
     * Moves device from registration waiting list to registered devices
     *
     * @param deviceNotRegistered Device on registration waiting list
     */
    public void addDevice(Devicenotregistered deviceNotRegistered) {
        try {
            Employee emp = addEmployee(deviceNotRegistered.getUsername(), deviceNotRegistered.getPassword(), deviceNotRegistered.getName(), deviceNotRegistered.getSurname(), deviceNotRegistered.getIdnumber());
            DeviceId id = new DeviceId(deviceNotRegistered.getId());
            Device dev = new Device(id, emp, deviceNotRegistered.getManufacturer(), deviceNotRegistered.getModel(), new Date(), deviceNotRegistered.getToken());
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dev);
            session.getTransaction().commit();
            session.close();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(deviceNotRegistered);
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

//
    /**
     *
     * @return Return this bean's instance of employee
     */
    public Employee getEmployee() {
        try {
            return employee;
        } catch (Exception e) {
            System.err.println("Employee does not exist");
        }
        return employee;
    }

    /**
     *
     * @return Returns a list of unregistered devices
     */
    public List getWaitingList() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered");
            waitingList = query.list();
            for (int i = 0; i < waitingList.size(); i++) {
                Hibernate.initialize(waitingList.get(i));
                Hibernate.initialize(waitingList.get(i).getDateRegistered());
                Hibernate.initialize(waitingList.get(i).getIdnumber());
                Hibernate.initialize(waitingList.get(i).getId());
                Hibernate.initialize(waitingList.get(i).getManufacturer());
                Hibernate.initialize(waitingList.get(i).getModel());
                Hibernate.initialize(waitingList.get(i).getName());
                Hibernate.initialize(waitingList.get(i).getSurname());
                Hibernate.initialize(waitingList.get(i).getToken());
                Hibernate.initialize(waitingList.get(i).getUsername());
                Hibernate.initialize(waitingList.get(i).getPassword());

            }
        } finally {
            session.close();
            return waitingList;
        }

    }

    /**
     *
     * @param id Employee's ID number
     * @return Returns a list of devices on the waiting list that belongs to a
     * specific employee
     */
    public List getWaitingList(String id) {
        List<Devicenotregistered> waitingListUnique = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Devicenotregistered where idnumber = :id");
            query.setParameter("id", id);
            waitingListUnique = query.list();
        } catch (HibernateException e) {
        }
        session.close();
        return waitingListUnique;
    }

    /**
     *
     * @return Returns all registered devices
     */
    public List getDeviceList() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Device");
            deviceList = query.list();
            for (int i = 0; i < deviceList.size(); i++) {
                Hibernate.initialize(deviceList.get(i));
                Hibernate.initialize(deviceList.get(i).getDateRegistered());
                Hibernate.initialize(deviceList.get(i).getEmployee());
                Hibernate.initialize(deviceList.get(i).getId());
                Hibernate.initialize(deviceList.get(i).getManufacturer());
                Hibernate.initialize(deviceList.get(i).getModel());
                Hibernate.initialize(deviceList.get(i).getScanresults());
                Hibernate.initialize(deviceList.get(i).getToken());

            }
        } finally {
            session.close();
            return deviceList;
        }
    }

    /**
     *
     * @return returns all registered employees
     */
    public List getEmployeeList() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee order by Surname asc");
            employeeList = query.list();
            for (int i = 0; i < employeeList.size(); i++) {
                Hibernate.initialize(employeeList.get(i));
                Hibernate.initialize(employeeList.get(i).getDateRegistered());
                Hibernate.initialize(employeeList.get(i).getIdnumber());
                Hibernate.initialize(employeeList.get(i).getName());
                Hibernate.initialize(employeeList.get(i).getSurname());
                Hibernate.initialize(employeeList.get(i).getUsername());
                Hibernate.initialize(employeeList.get(i).getPassword());
                Hibernate.initialize(employeeList.get(i).getDevices());
                Hibernate.initialize(employeeList.get(i).getEmpId());

            }
        } finally {
            session.close();
            return employeeList;
        }

    }

    /**
     *
     * @return Returns all blacklisted applications
     */
    public List<Blacklistedapp> getApps() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Blacklistedapp");
            apps = query.list();
            for (int i = 0; i < apps.size(); i++) {
                Hibernate.initialize(apps.get(i));
                Hibernate.initialize(apps.get(i).getAppCategory());
                Hibernate.initialize(apps.get(i).getAppId());
                Hibernate.initialize(apps.get(i).getAppName());
            }
        } finally {
            session.close();
            return apps;
        }


    }

    /**
     *
     * @return Returns the latest setting
     */
    public Setting getLatestSetting() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Setting order by SettingDate desc");
            List setting = query.list();
            latestSetting = (Setting) setting.get(0);
            rootedWeight = latestSetting.getRootedWeight();
            debugWeight = latestSetting.getDebugWeight();
            unknownSourcesWeight = latestSetting.getUnknownSourcesWeight();
            osWeight = latestSetting.getApiweight();
            lowRiskApp = latestSetting.getLowRiskApp();
            mediumRiskApp = latestSetting.getMediumRiskApp();
            highRiskApp = latestSetting.getHighRiskApp();
            blockedApp = latestSetting.getBlockedApp();
            accessScore = latestSetting.getAccessScore();
        } finally {
            session.close();
            return latestSetting;
        }

    }

    /**
     * Saves a device's scan, calculates device score and determines if test was
     * passed
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @param rooted True if device is rooted
     * @param debug True if USB Debugging is enabled
     * @param unknown True if applications from unknown sources are allowed
     * @param installedApps List of all installed applications on the device
     * @param api API Level of device
     * @return Returns true if device's score is lower than the access score
     */
    public boolean addScanResults(String mac, String serial, String androidID, boolean rooted, boolean debug, boolean unknown, String installedApps, int api) {
        getLatestSetting();
        getApps();
        int totalScore;
        int rootScore = 0;
        int debugScore = 0;
        int unknownScore = 0;
        int appScore = 0;
        int apiScore;

        if (rooted) {
            rootScore = latestSetting.getRootedWeight();
        }
        if (debug) {
            debugScore = latestSetting.getDebugWeight();
        }
        if (unknown) {
            unknownScore = latestSetting.getUnknownSourcesWeight();
        }

        String blacklistedApps = "";
        String[] appArray = installedApps.split(",");
        for (int i = 0; i < appArray.length; i++) {
            int k = 0;
            while (k < apps.size()) {
                if (appArray[i].contains(apps.get(k).getAppName())) {
                    String cat = apps.get(k).getAppCategory();
                    if (!blacklistedApps.equals("")) {
                        blacklistedApps += ", ";
                    }
                    blacklistedApps += appArray[i];

                    if (cat.equals("Low")) {
                        appScore += latestSetting.getLowRiskApp();
                    } else if (cat.equals("Medium")) {
                        appScore += latestSetting.getMediumRiskApp();
                    } else if (cat.equals("High")) {
                        appScore += latestSetting.getHighRiskApp();
                    } else if (cat.equals("Blocked")) {
                        appScore += latestSetting.getBlockedApp();
                    }
                }
                k++;
            }
        }

        if (blacklistedApps.equals("")) {
            blacklistedApps = "None";
        }
        apiScore = (17 - api) * latestSetting.getApiweight();
        totalScore = rootScore + debugScore + unknownScore + appScore + apiScore;
        boolean allow = false;
        if (totalScore < latestSetting.getAccessScore()) {
            allow = true;
        }

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where MACAddress = :mac and AndroidID = :androidid and SerialNumber = :serial");
        query.setParameter("mac", mac);
        query.setParameter("serial", serial);
        query.setParameter("androidid", androidID);
        List<Device> devices = query.list();
        Device dev = devices.get(0);
        results = new Scanresult(dev, latestSetting, new Date(), rooted, rootScore, debug, debugScore, unknown, unknownScore, blacklistedApps, appScore, Integer.toString(api), apiScore, totalScore, allow);
        session.save(results);
        session.getTransaction().commit();
        session.close();
        return allow;

    }

    /**
     *
     * @param id Employee's ID
     * @return Returns a list of devices registered to an employee
     */
    public List getEmployeeDevices(int id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Device where employee_empID = :id");
            query.setParameter("id", id);
            employeeDevices = query.list();
            for (int i = 0; i < employeeDevices.size(); i++) {
                Hibernate.initialize(employeeDevices.get(i));
                Hibernate.initialize(employeeDevices.get(i).getDateRegistered());
                Hibernate.initialize(employeeDevices.get(i).getEmployee());
                Hibernate.initialize(employeeDevices.get(i).getId());
                Hibernate.initialize(employeeDevices.get(i).getManufacturer());
                Hibernate.initialize(employeeDevices.get(i).getModel());
                Hibernate.initialize(employeeDevices.get(i).getScanresults());
                Hibernate.initialize(employeeDevices.get(i).getToken());
            }
        } finally {
            session.close();
            return employeeDevices;
        }

    }

    /**
     *
     * @param id Device's ID
     * @return Returns a link to the device
     */
    public String setDevice(DeviceId id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Scanresult where device_MACAddress = :mac and device_UID = :androidid and device_SerialNumber = :serial order by Date desc");
            query.setParameter("mac", id.getMacaddress());
            query.setParameter("androidid", id.getAndroidId());
            query.setParameter("serial", id.getSerialNumber());
            device_results = query.list();
            query = session.createQuery("from Device where MACAddress = :mac and AndroidID = :androidid and SerialNumber = :serial");
            query.setParameter("mac", id.getMacaddress());
            query.setParameter("androidid", id.getAndroidId());
            query.setParameter("serial", id.getSerialNumber());
            device = (Device) query.list().get(0);
            Hibernate.initialize(device.getDateRegistered());
            Hibernate.initialize(device.getEmployee());
            Hibernate.initialize(device.getId());
            Hibernate.initialize(device.getManufacturer());
            Hibernate.initialize(device.getModel());
            Hibernate.initialize(device.getScanresults());
            Hibernate.initialize(device.getToken());
        } finally {
            session.close();
            return "device.xhtml";
        }

    }

    public void setDev(Device dev) {
        try {
            device = dev;
        } catch (Exception e) {
        }

    }

    /**
     *
     * @return Returns a list of scan results for current device
     */
    public List getDevice_Results() {
        return device_results;
    }

    /**
     *
     * @return Returns the number of registered devices
     */
    public int getDeviceSize() {
        return getDeviceList().size();
    }

    /**
     *
     * @return Returns current device
     */
    public Device getDevice() {
        return device;
    }

    /**
     *
     * @return Returns number of devices in waiting list
     */
    public int getQueueSize() {
        return getWaitingList().size();

    }

    /**
     *
     * @return Returns number of scans that passed
     */
    public int getAllowed() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = true");
        allowed = query.list().size();
        session.close();
        return allowed;
    }

    /**
     *
     * @return Returns number of devices that failed
     */
    public int getDenied() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = false");
        denied = query.list().size();
        session.close();
        return denied;
    }

    /**
     * Remove a device
     *
     * @param device Device
     * @return Returns a link back to the devices page
     */
    public String removeDevice(Device device) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Scanresult where device_MACAddress = :mac and device_UID = :androidid and device_SerialNumber = :serial");
        query.setParameter("mac", device.getId().getMacaddress());
        query.setParameter("androidid", device.getId().getAndroidId());
        query.setParameter("serial", device.getId().getSerialNumber());
        query.executeUpdate();
        query = session.createQuery("delete from Device where MACAddress = :mac and AndroidID = :androidid and SerialNumber = :serial");
        query.setParameter("mac", device.getId().getMacaddress());
        query.setParameter("androidid", device.getId().getAndroidId());
        query.setParameter("serial", device.getId().getSerialNumber());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return "devices.xhtml";
    }

    /**
     * Remove a device
     *
     * @param emp Employee
     * @return Returns a link back to the users page
     */
    public String removeEmployee(Employee emp) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where employee_empID = :id");
        query.setParameter("id", emp.getEmpId());
        List<Device> devices = query.list();
        if (!devices.isEmpty()) {
            for (int i = 0; i < devices.size(); i++) {
                removeDevice(devices.get(i));
            }
        }
        query = session.createQuery("delete from Employee where empid = :id");
        query.setParameter("id", emp.getEmpId());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return "users.xhtml";
    }

    /**
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @return Returns the latest scan of a device
     */
    public Scanresult getLatestScan(String mac, String serial, String androidID) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where device_MACAddress = :mac and device_UID = :uid and device_SerialNumber = :serial order by Date desc");
        query.setParameter("mac", mac);
        query.setParameter("uid", androidID);
        query.setParameter("serial", serial);
        Scanresult scan = (Scanresult) query.list().get(0);
        session.close();
        return scan;

    }

    /**
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @return Returns a device's token
     */
    public String getToken(String mac, String androidID, String serial) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where MACAddress = :mac and AndroidID = :uid and SerialNumber = :serial");
        query.setParameter("mac", mac);
        query.setParameter("uid", androidID);
        query.setParameter("serial", serial);
        Device dev = (Device) query.list().get(0);
        String token = dev.getToken();
        session.close();
        return token;
    }

    /**
     *
     * @param username Employee's username
     * @param password Employee's password
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @param ip Device's IP Address
     * @return Returns true if login is successful
     */
    public boolean login(String username, String password, String mac, String androidID, String serial, String ip) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device where MACAddress = :mac and AndroidID = :uid and SerialNumber = :serial");
        query.setParameter("mac", mac);
        query.setParameter("uid", androidID);
        query.setParameter("serial", serial);
        Device dev = (Device) query.list().get(0);
        Employee emp = dev.getEmployee();
        if (emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
            Activeuser user = new Activeuser(ip, mac, androidID, serial);
            session.save(user);
            session.getTransaction().commit();
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    /**
     *
     * @param ip Remote host IP address
     * @return REturns true if logged in
     */
    public boolean isActiveUser(String ip) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Activeuser where ip = :ip");
        query.setParameter("ip", ip);
        List<Activeuser> list = query.list();
        if (list.isEmpty()) {
            session.close();
            return false;
        } else {
            session.close();
            return true;
        }

    }

    /**
     *
     * @param mac Device's MAC Address
     * @param serial Device's serial number
     * @param androidID Device's Android ID
     * @param remoteAddr IP Address of remote host
     */
    public void logout(String mac, String androidID, String serial, String remoteAddr) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Activeuser where deviceMacaddress = :mac and deviceAndroidId = :androidID and deviceSerialNumber = :serial and ip = :remoteAddr");
        query.setParameter("mac", mac);
        query.setParameter("androidID", androidID);
        query.setParameter("serial", serial);
        query.setParameter("remoteAddr", remoteAddr);
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();

    }
}
