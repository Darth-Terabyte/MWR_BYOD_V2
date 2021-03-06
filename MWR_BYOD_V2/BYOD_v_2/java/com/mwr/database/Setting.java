package com.mwr.database;
// Generated 24 Sep 2013 1:24:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Setting generated by hbm2java
 */
public class Setting  implements java.io.Serializable {


     private Integer settingId;
     private int accessScore;
     private Date settingDate;
     private int apiweight;
     private int rootedWeight;
     private int debugWeight;
     private int unknownSourcesWeight;
     private int lowRiskApp;
     private int mediumRiskApp;
     private int highRiskApp;
     private int blockedApp;
     private Set scanresults = new HashSet(0);

    /**
     *
     */
    public Setting() {
    }

	
    /**
     *
     * @param accessScore
     * @param settingDate
     * @param apiweight
     * @param rootedWeight
     * @param debugWeight
     * @param unknownSourcesWeight
     * @param lowRiskApp
     * @param mediumRiskApp
     * @param highRiskApp
     * @param blockedApp
     */
    public Setting(int accessScore, Date settingDate, int apiweight, int rootedWeight, int debugWeight, int unknownSourcesWeight, int lowRiskApp, int mediumRiskApp, int highRiskApp, int blockedApp) {
        this.accessScore = accessScore;
        this.settingDate = settingDate;
        this.apiweight = apiweight;
        this.rootedWeight = rootedWeight;
        this.debugWeight = debugWeight;
        this.unknownSourcesWeight = unknownSourcesWeight;
        this.lowRiskApp = lowRiskApp;
        this.mediumRiskApp = mediumRiskApp;
        this.highRiskApp = highRiskApp;
        this.blockedApp = blockedApp;
    }
    /**
     *
     * @param accessScore
     * @param settingDate
     * @param apiweight
     * @param rootedWeight
     * @param debugWeight
     * @param unknownSourcesWeight
     * @param lowRiskApp
     * @param mediumRiskApp
     * @param highRiskApp
     * @param blockedApp
     * @param scanresults
     */
    public Setting(int accessScore, Date settingDate, int apiweight, int rootedWeight, int debugWeight, int unknownSourcesWeight, int lowRiskApp, int mediumRiskApp, int highRiskApp, int blockedApp, Set scanresults) {
       this.accessScore = accessScore;
       this.settingDate = settingDate;
       this.apiweight = apiweight;
       this.rootedWeight = rootedWeight;
       this.debugWeight = debugWeight;
       this.unknownSourcesWeight = unknownSourcesWeight;
       this.lowRiskApp = lowRiskApp;
       this.mediumRiskApp = mediumRiskApp;
       this.highRiskApp = highRiskApp;
       this.blockedApp = blockedApp;
       this.scanresults = scanresults;
    }
   
    /**
     *
     * @return
     */
    public Integer getSettingId() {
        return this.settingId;
    }
    
    /**
     *
     * @param settingId
     */
    public void setSettingId(Integer settingId) {
        this.settingId = settingId;
    }
    /**
     *
     * @return
     */
    public int getAccessScore() {
        return this.accessScore;
    }
    
    /**
     *
     * @param accessScore
     */
    public void setAccessScore(int accessScore) {
        this.accessScore = accessScore;
    }
    /**
     *
     * @return
     */
    public Date getSettingDate() {
        return this.settingDate;
    }
    
    /**
     *
     * @param settingDate
     */
    public void setSettingDate(Date settingDate) {
        this.settingDate = settingDate;
    }
    /**
     *
     * @return
     */
    public int getApiweight() {
        return this.apiweight;
    }
    
    /**
     *
     * @param apiweight
     */
    public void setApiweight(int apiweight) {
        this.apiweight = apiweight;
    }
    /**
     *
     * @return
     */
    public int getRootedWeight() {
        return this.rootedWeight;
    }
    
    /**
     *
     * @param rootedWeight
     */
    public void setRootedWeight(int rootedWeight) {
        this.rootedWeight = rootedWeight;
    }
    /**
     *
     * @return
     */
    public int getDebugWeight() {
        return this.debugWeight;
    }
    
    /**
     *
     * @param debugWeight
     */
    public void setDebugWeight(int debugWeight) {
        this.debugWeight = debugWeight;
    }
    /**
     *
     * @return
     */
    public int getUnknownSourcesWeight() {
        return this.unknownSourcesWeight;
    }
    
    /**
     *
     * @param unknownSourcesWeight
     */
    public void setUnknownSourcesWeight(int unknownSourcesWeight) {
        this.unknownSourcesWeight = unknownSourcesWeight;
    }
    /**
     *
     * @return
     */
    public int getLowRiskApp() {
        return this.lowRiskApp;
    }
    
    /**
     *
     * @param lowRiskApp
     */
    public void setLowRiskApp(int lowRiskApp) {
        this.lowRiskApp = lowRiskApp;
    }
    /**
     *
     * @return
     */
    public int getMediumRiskApp() {
        return this.mediumRiskApp;
    }
    
    /**
     *
     * @param mediumRiskApp
     */
    public void setMediumRiskApp(int mediumRiskApp) {
        this.mediumRiskApp = mediumRiskApp;
    }
    /**
     *
     * @return
     */
    public int getHighRiskApp() {
        return this.highRiskApp;
    }
    
    /**
     *
     * @param highRiskApp
     */
    public void setHighRiskApp(int highRiskApp) {
        this.highRiskApp = highRiskApp;
    }
    /**
     *
     * @return
     */
    public int getBlockedApp() {
        return this.blockedApp;
    }
    
    /**
     *
     * @param blockedApp
     */
    public void setBlockedApp(int blockedApp) {
        this.blockedApp = blockedApp;
    }
    /**
     *
     * @return
     */
    public Set getScanresults() {
        return this.scanresults;
    }
    
    /**
     *
     * @param scanresults
     */
    public void setScanresults(Set scanresults) {
        this.scanresults = scanresults;
    }




}


