package com.mwr.database;
// Generated 23 Sep 2013 5:37:49 PM by Hibernate Tools 3.2.1.GA


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
     private Set scanresults = new HashSet(0);

    public Device() {
    }

	
    public Device(DeviceId id, Employee employee, String manufacturer, String model, Date dateRegistered) {
        this.id = id;
        this.employee = employee;
        this.manufacturer = manufacturer;
        this.model = model;
        this.dateRegistered = dateRegistered;
    }
    public Device(DeviceId id, Employee employee, String manufacturer, String model, Date dateRegistered, Set scanresults) {
       this.id = id;
       this.employee = employee;
       this.manufacturer = manufacturer;
       this.model = model;
       this.dateRegistered = dateRegistered;
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
    public Set getScanresults() {
        return this.scanresults;
    }
    
    public void setScanresults(Set scanresults) {
        this.scanresults = scanresults;
    }




}


