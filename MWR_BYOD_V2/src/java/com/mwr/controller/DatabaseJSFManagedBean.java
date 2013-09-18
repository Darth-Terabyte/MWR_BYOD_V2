/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import com.mwr.businesslogic.TokenGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Heindrich
 */
@ManagedBean(name = "bean")
@SessionScoped
public class DatabaseJSFManagedBean {

    private Session session;
    private HibernateUtil helper;
    private Employee employee;
    private Device device;
    private Devicenotregistered device_not;
    private List<Devicenotregistered> waitingList;
    private List<Device> deviceList;
    private List<Employee> employeeList;
    private List<Technician> technicianList, techAdmin, techNonAdmin;
    private List<String> systemStatus;
    private String mac;
    private String serial;
    private String android;
    private Settings latestSetting;
    private List<Blacklistedapplications> apps;
    private Scanresults results;
    private List<Scanresults> device_results;

    /**
     * Creates a new instance of DatabaseJSFManagedBean
     */
    public DatabaseJSFManagedBean() {

        session = HibernateUtil.getSessionFactory().openSession();

    }

    /*===============================================
     *||                  To do                    ||
     *===============================================
     */
    //logout link to log out user
    public void logout() {
    }

    //get a specific Device for an Employee
    public Device getDevice(String devid) {
        return null;
    }

    //get a specific Scanresults for a Device
    public Scanresults getScanResult(String scanid) {
        return null;
    }

    //get a token for a Device for an Employee
    public String getDeviceToken(String devid) {
        return null;
    }
    //check if device registered
    public Boolean deviceRegistered(String devid) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Devicenotregistered where id =" + devid);
        List<Devicenotregistered> d = query.list();
        if (d.isEmpty())
            return false;
        else return true;
    }
    
    //add a blacklisted Application
    public void addBlacklistedApp(String name, String Catagory)
    {
        
    }    
    //change a blacklisted Application's catagory
    public void changeAppCatagory(int id, String Catagory)
    {
        
    }
    //remove a blacklisted Application
    public void removeBlacklistedApp(int id)
    {
        
    }
    //Save WeightSystem Settings
    public void saveWeightSettings()
    {
        
    }
    
    //Save Blacklisted Applications Settings
    public void saveBlacklistedSettings()
    {
        
    }
    //Save Blacklisted Applications Settings
    public void saveBlacklistedCatagorySettings()
    {
        
    }
    //Save OS Settings
    public void saveOSSettings()
    {
        
    }
    
    //Save Scan Settings
    public void saveScanSettings()
    {
        
    }

    /*===============================================
     *||               To do END                   ||
     *===============================================
     */
    /*===============================================
     *||            Newly added                    ||
     *===============================================
     */
    //get path to relevent link. (Dit lyk beter)
    public String getLink(String link) {

        return "/BYOD/faces/view/" + link + ".xhtml";
    }

    //get the Employee with the empId = id
    public Employee getEmployee(String id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Employee where empId = " + id);
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
    //get the Devices owned by the Employee with the empId = id
    public List<Device> getEmployeeDevices(String id) {
        Employee e = getEmployee(id);
        return (List<Device>) e.getDevices();
    }

    /*===============================================
     *||         Newly added END                   ||
     *===============================================
     */
    /*===============================================
     *||           Technician stuff                ||
     *===============================================
     */
    //validate password for a Technician
    public Boolean correctPassword(String empid) {
        return null;
    }

    //validate password1 == password2
    public Boolean matchPasswords(String p1, String p2) {
        return null;
    }

    /*===============================================
     *||         Technician stuff END              ||
     *===============================================
     */
    public void addToWaitingList(String mac, String android, String serial, String make, String model, String username, String password, String idnumber, String name, String surname) throws NoSuchAlgorithmException {
        try {
            TokenGenerator gen = new TokenGenerator();
            String token = gen.generateToken(mac, android, serial);
            DevicenotregisteredId devicePK = new DevicenotregisteredId(mac, android, serial);
            device_not = new Devicenotregistered(devicePK, make, model, username, password, idnumber, name, surname, token);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(device_not);
            session.getTransaction().commit();
        } finally {
            session.close();
        }

    }

    public Employee addEmployee(String username, String password, String name, String surname, String idnumber) {
        employee = new Employee(username, password, new Date(), name, surname, idnumber);
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    public void addDevice(Devicenotregistered d) {
        try {

            Employee emp = addEmployee(d.getUsername(), d.getPassword(), d.getName(), d.getSurname(), d.getIdnumber());
            DeviceId id = new DeviceId(d.getId());
            Device dev = new Device(id, emp, d.getMake(), d.getModel(), new Date());
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(dev);
            session.getTransaction().commit();
             session.close();
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(d);
            session.getTransaction().commit();

        } finally {
            session.close();
        }

    }

    public void addTechnician(String employeeCode, String userName, String password, Date dateRegistered, boolean admin) {
        Technician tech = new Technician(employeeCode, userName, password, dateRegistered, admin);
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(tech);
        session.getTransaction().commit();
        session.close();
    }

    public List getWaitingList() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Devicenotregistered");
        waitingList = query.list();
        return waitingList;
    }

    public List getDeviceList() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Device");
        deviceList = query.list();
        return deviceList;
    }

    public List getTechnicianList() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Technician");
        technicianList = query.list();
        return technicianList;
    }

    public List getTechnicianAdminList() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Technician");
        technicianList = query.list();
        for (int i = 0; i < technicianList.size(); i++) {
            if (technicianList.get(i).isAdmin()) {
                techAdmin.add(technicianList.get(i));
            } else {
                techNonAdmin.add(technicianList.get(i));
            }
        }
        return technicianList;
    }

    public List getEmployeeList() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee");
        employeeList = query.list();
        return employeeList;
    }

    public List getBlacklistedApps() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Blacklistedapplications");
        apps = query.list();
        return apps;
    }

    public List showSystemStatus() {
        getLatestSetting();

        return systemStatus;
    }

    public Settings getLatestSetting() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Settings order by SettingDate desc");
        List settings = query.list();
        latestSetting = (Settings) settings.get(0);
        return latestSetting;
    }

    public boolean addScanResults(String mac, String serial, String androidID, boolean rooted, boolean debug, boolean unknown, String installedApps, int api) {
        getLatestSetting();
        getBlacklistedApps();
        int totalScore = 0;
        int rootScore = 0;
        int debugScore = 0;
        int unknownScore = 0;
        int appScore = 0;
        int apiScore = 0;

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

        apiScore = (17 - api) * latestSetting.getOsweight();
        totalScore = rootScore + debugScore + unknownScore + appScore + apiScore;
        boolean allowed = false;
        if (totalScore < latestSetting.getAccessScore()) {
            allowed = true;
        }

        results = new Scanresults(latestSetting, new Date(), rooted, rootScore, debug, debugScore, unknown, unknownScore, blacklistedApps, appScore, Integer.toString(api), apiScore, totalScore, allowed, mac, androidID, serial);
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(results);
        session.getTransaction().commit();
        session.close();

        return allowed;

    }

    public String setDevice(DeviceId id) {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresults where device_MACAddress = :mac and device_UID = :uid and device_SerialNumber = :serial order by Date desc");
        query.setParameter("mac", id.getMacaddress());
        query.setParameter("uid", id.getUid());
        query.setParameter("serial", id.getSerialNumber());
        device_results = query.list();
        return "scan.xhtml";
    }

    public List getDevice_Results() {
        return device_results;
    }

    public int getDeviceSize() {
        return getDeviceList().size();

    }

    public int getQueueSize() {
        return getWaitingList().size();

    }

    public int getAllowed() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresults where accessAllowed = true");
        return query.list().size();
    }

    public int getDenied() {
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresults where accessAllowed = false");
        return query.list().size();
    }
}
