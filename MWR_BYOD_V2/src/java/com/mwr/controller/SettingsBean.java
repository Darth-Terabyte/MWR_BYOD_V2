package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 * @version 2.0
 * @author LuxInTenebris
 */
@ManagedBean(name = "settings")
@SessionScoped
public class SettingsBean implements Serializable {

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

    /**
     *
     */
    public SettingsBean() {
        //Setting s = getLatestSetting();
    }

    /**
     *
     * @return
     */
    public int getRootedWeight() {
        return rootedWeight;
    }

    /**
     *
     * @return
     */
    public int getDebugWeight() {
        return debugWeight;
    }

    /**
     *
     * @return
     */
    public int getUnknownSourcesWeight() {
        return unknownSourcesWeight;
    }

    /**
     *
     * @return
     */
    public int getOsWeight() {
        return osWeight;
    }

    /**
     *
     * @return
     */
    public int getLowRiskApp() {
        return lowRiskApp;
    }

    /**
     *
     * @return
     */
    public int getMediumRiskApp() {
        return mediumRiskApp;
    }

    /**
     *
     * @return
     */
    public int getHighRiskApp() {
        return highRiskApp;
    }

    /**
     *
     * @return
     */
    public int getBlockedApp() {
        return blockedApp;
    }

    /**
     *
     * @return
     */
    public int getAccessScore() {
        return accessScore;
    }

    /**
     *
     * @param weight
     */
    public void setRootedWeight(int weight) {
        rootedWeight = weight;
    }

    /**
     *
     * @param weight
     */
    public void setDebugWeight(int weight) {
        debugWeight = weight;
    }

    /**
     *
     * @param weight
     */
    public void setUnknownSourcesWeight(int weight) {
        unknownSourcesWeight = weight;
    }

    /**
     *
     * @param weight
     */
    public void setOsWeight(int weight) {
        osWeight = weight;
    }

    /**
     *
     * @param weight
     */
    public void setLowRiskApp(int weight) {
        lowRiskApp = weight;
    }

    /**
     *
     * @param weight
     */
    public void setMediumRiskApp(int weight) {
        mediumRiskApp = weight;
    }

    /**
     *
     * @param weight
     */
    public void setHighRiskApp(int weight) {
        highRiskApp = weight;
    }

    /**
     *
     * @param weight
     */
    public void setBlockedApp(int weight) {
        blockedApp = weight;
    }

    /**
     *
     * @param weight
     */
    public void setAccessScore(int weight) {
        accessScore = weight;
    }

    /**
     *
     * @return
     */
    public String getAppName() {
        return appName;
    }

    /**
     *
     * @param appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     *
     * @return
     */
    public String getAppCategory() {
        return appCategory;
    }

    /**
     *
     * @param appCategory
     */
    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    /**
     *
     */
    public void saveSettings() {
        addSetting();
    }

    /**
     *
     * @return
     */
    public String addSetting() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Setting setting = new Setting(accessScore, new Date(), osWeight, rootedWeight, debugWeight, unknownSourcesWeight, lowRiskApp, mediumRiskApp, highRiskApp, blockedApp);
        session.save(setting);
        session.getTransaction().commit();
        session.close();
        return "settings.xhtml";
    }

    //add a blacklisted Application
    /**
     *
     * @return
     */
    public String addBlacklistedApp() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Blacklistedapp app = new Blacklistedapp(appName, appCategory);
        session.save(app);
        session.getTransaction().commit();
        session.close();
        appName = "";
        appCategory = "";
        return "settings.xhtml";
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @param app
     * @return
     */
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

    /**
     *
     * @return
     */
    public List<Setting> getSettings() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Setting");
        settings = query.list();
        return settings;
    }

    /**
     *
     * @return
     */
    public List<Scanresult> getAllowedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 1");
        allowedScans = query.list();
        return allowedScans;
    }

    /**
     *
     * @return
     */
    public List<Scanresult> getDeniedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 0");
        deniedScans = query.list();
        return deniedScans;
    }

    /**
     *
     * @param id
     * @return
     */
    public String setSpecificSetting(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        specificSetting = (Setting) session.get(Setting.class, id);
        return "specificSetting.xhtml";
    }

    /**
     *
     * @return
     */
    public Setting getSpecificSetting() {
        return specificSetting;
    }
}
