
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name = "settings")
@SessionScoped
public class SettingsBean {

    private Session session;
    private int rootedWeight;
    private int debugWeight;
    private int unknownSourcesWeight;
    private int osWeight;
    private int lowRiskApp;
    private int mediumRiskApp;
    private int highRiskApp;
    private int blockedApp;
    private int accessScore; 
    private String appName;
    private String appCategory;
    private Setting latestSetting;
    private List<Setting> settings;
    private List<Scanresult> allowedScans;
    private List<Scanresult> deniedScans;        
    private Setting specificSetting;
    
    public int getRootedWeight() {
        return rootedWeight;
    }

    public int getDebugWeight() {
        return debugWeight;
    }

    public int getUnknownSourcesWeight() {
        return unknownSourcesWeight;
    }

    public int getOsWeight() {
        return osWeight;
    }

    public int getLowRiskApp() {
        return lowRiskApp;
    }

    public int getMediumRiskApp() {
        return mediumRiskApp;
    }

    public int getHighRiskApp() {
        return highRiskApp;
    }

    public int getBlockedApp() {
        return blockedApp;
    }

    public int getAccessScore() {
        return accessScore;
    }

    public void setRootedWeight(int weight) {
        rootedWeight = weight;
    }

    public void setDebugWeight(int weight) {
        debugWeight = weight;
    }

    public void setUnknownSourcesWeight(int weight) {
        unknownSourcesWeight = weight;
    }

    public void setOsWeight(int weight) {
        osWeight = weight;
    }

    public void setLowRiskApp(int weight) {
        lowRiskApp = weight;
    }

    public void setMediumRiskApp(int weight) {
        mediumRiskApp = weight;
    }

    public void setHighRiskApp(int weight) {
        highRiskApp = weight;
    }

    public void setBlockedApp(int weight) {
        blockedApp = weight;
    }

    public void setAccessScore(int weight) {
        accessScore = weight;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }  
    
    public void saveSettings()
    {
        addSetting();
    }

    public String addSetting() {

        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(osWeight));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(rootedWeight));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(debugWeight));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(unknownSourcesWeight));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(lowRiskApp));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(mediumRiskApp));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(highRiskApp));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(blockedApp));
        Logger.getLogger(DatabaseJSFManagedBean.class.getName()).info(Integer.toString(accessScore));

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Setting setting = new Setting(accessScore, new Date(), osWeight, rootedWeight, debugWeight, unknownSourcesWeight, lowRiskApp, mediumRiskApp, highRiskApp, blockedApp);
        latestSetting = setting;
        session.save(setting);
        session.getTransaction().commit();
        session.close();
        return "settings.xhtml";
    }
    
    //add a blacklisted Application
    public String addBlacklistedApp() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Blacklistedapp app = new Blacklistedapp(appName, appCategory);
        session.save(app);
        session.getTransaction().commit();
        session.close();
        return "settings.xhtml";
    }
    
    public Setting getLatestSetting() {
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
        session.close();
        return latestSetting;
    }
    
    public String removeApp(Blacklistedapp app) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("delete from Blacklistedapp where appID = :id");
        query.setParameter("id", app.getAppId());
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        return "settings.xhtml";
    }

    public List<Setting> getSettings() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Setting");
        settings = query.list();
        return settings;
    }

    public List<Scanresult> getAllowedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 1");
        allowedScans = query.list();
        return allowedScans;
    }

    public List<Scanresult> getDeniedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 0");
        deniedScans = query.list();
        return deniedScans;
    }

    public String setSpecificSetting(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        specificSetting = (Setting) session.get(Setting.class, id);
        return "specificSetting.xhtml";
    }

    public Setting getSpecificSetting() {
        return specificSetting;
    }


}
