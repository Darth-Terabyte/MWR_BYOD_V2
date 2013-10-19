package com.mwr.database;
// Generated 24 Sep 2013 1:24:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Device generated by hbm2java
 */
public class Device  implements java.io.Serializable {


     private DeviceId id;
     private Employee employee;
     private String manufacturer;
     private String model;
     private Date dateRegistered;
     private String token;
     private Set scanresults = new HashSet(0);

    public Device() {
    }

	
    public Device(DeviceId id, Employee employee, String manufacturer, String model, Date dateRegistered, String token) {
        this.id = id;
        this.employee = employee;
        this.manufacturer = manufacturer;
        this.model = model;
        this.dateRegistered = dateRegistered;
        this.token = token;
    }
    public Device(DeviceId id, Employee employee, String manufacturer, String model, Date dateRegistered, String token, Set scanresults) {
       this.id = id;
       this.employee = employee;
       this.manufacturer = manufacturer;
       this.model = model;
       this.dateRegistered = dateRegistered;
       this.token = token;
       this.scanresults = scanresults;
    }
   
    public DeviceId getId() {
        return this.id;
    }
    
    public void setId(DeviceId id) {
        this.id = id;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public String getManufacturer() {
        return this.manufacturer;
    }
    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getModel() {
        return this.model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    public Date getDateRegistered() {
        return this.dateRegistered;
    }
    
    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
    public String getToken() {
        return this.token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    public Set getScanresults() {
        return this.scanresults;
    }
    
    public void setScanresults(Set scanresults) {
        this.scanresults = scanresults;
    }




}


