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
     * Getter for the weight that a rooted device currently has against it.
     *
     * @return the weight this device currently has against it
     */
    public int getRootedWeight() {
        return rootedWeight;
    }

    /**
     * Getter for the weight that a device with USB debugging enabled currently
     * has against it.
     *
     * @return the weight this device currently has against it
     */
    public int getDebugWeight() {
        return debugWeight;
    }

    /**
     * Getter for the weight that a device with Unknown sources enabled
     * currently has against it.
     *
     * @return the weight this device currently has against it
     */
    public int getUnknownSourcesWeight() {
        return unknownSourcesWeight;
    }

    /**
     * Getter for the weight that a device's Android API version currently has
     * against it. This is needed due to the security changes in each API, and
     * thus some Operating Systems
     *
     * @return the weight this device currently has against it
     */
    public int getOsWeight() {
        return osWeight;
    }

    /**
     * Getter for the weight that a device currently has against it if it has a
     * low risk application installed.
     *
     * @return the weight this device currently has against it
     */
    public int getLowRiskApp() {
        return lowRiskApp;
    }

    /**
     * Getter for the weight that a device currently has against it if it has a
     * medium risk application installed.
     *
     * @return the weight this device currently has against it
     */
    public int getMediumRiskApp() {
        return mediumRiskApp;
    }

    /**
     * Getter for the weight that a device currently has against it if it has a
     * high risk application installed.
     *
     * @return the weight this device currently has against it
     */
    public int getHighRiskApp() {
        return highRiskApp;
    }

    /**
     * Getter for the weight that a device currently has against it if it has a
     * blocked application installed.
     *
     * @return the weight this device currently has against it
     */
    public int getBlockedApp() {
        return blockedApp;
    }

    /**
     * Getter for the weight that a device currently should have to gain access
     * to the network.
     *
     * @return the needed access weight
     */
    public int getAccessScore() {
        return accessScore;
    }

    /**
     * Setter for the weight that a device currently has against it if it is
     * rooted.
     *
     * @param weight is the weight we would like a rooted device to have against
     * it.
     */
    public void setRootedWeight(int weight) {
        rootedWeight = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if USB
     * debugging is enabled.
     *
     * @param weight is the weight we would like a device with USB debugging
     * enabled to have against it.
     */
    public void setDebugWeight(int weight) {
        debugWeight = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if Unknown
     * Sources is allowed.
     *
     * @param weight is the weight we would like a device with Unknown Sources
     * is allowed to have against it.
     */
    public void setUnknownSourcesWeight(int weight) {
        unknownSourcesWeight = weight;
    }

    /**
     * Setter for the weight that a device currently has against it dependent on
     * it's API level.
     *
     * @param weight is the weight we would like a device to have against it
     * dependant on it's API level.
     */
    public void setOsWeight(int weight) {
        osWeight = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if it has a
     * low risk application installed.
     *
     * @param weight is the weight we would like a device to have against it if
     * it has a low risk application installed.
     */
    public void setLowRiskApp(int weight) {
        lowRiskApp = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if it has a
     * medium risk application installed.
     *
     * @param weight is the weight we would like a device to have against it if
     * it has a medium risk application installed.
     */
    public void setMediumRiskApp(int weight) {
        mediumRiskApp = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if it has a
     * high risk application installed.
     *
     * @param weight is the weight we would like a device to have against it if
     * it has a high risk application installed.
     */
    public void setHighRiskApp(int weight) {
        highRiskApp = weight;
    }

    /**
     * Setter for the weight that a device currently has against it if it has a
     * blocked application installed.
     *
     * @param weight is the weight we would like a device to have against it if
     * it has a blocked application installed.
     */
    public void setBlockedApp(int weight) {
        blockedApp = weight;
    }

    /**
     * Setter for the weight that a device currently would need to gain access
     * to the network.
     *
     * @param weight is the weight required to gain access to the network.
     */
    public void setAccessScore(int weight) {
        accessScore = weight;
    }

    /**
     * Getter for the name of an application.
     *
     * @return the name of the application.
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Setter for the name of an application.
     *
     * @param appName the name of the application.
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Getter for the category of an application. Categories are
     * [Low|Medium|High|Blocked].
     *
     * @return the category of the application.
     */
    public String getAppCategory() {
        return appCategory;
    }

    /**
     * Setter for the category of an application. Categories are
     * [Low|Medium|High|Blocked].
     *
     * @return the category of the application.
     */
    public void setAppCategory(String appCategory) {
        if (appCategory.toLowerCase().equals("low")
                || appCategory.toLowerCase().equals("medium")
                || appCategory.toLowerCase().equals("high")
                || appCategory.toLowerCase().equals("blocked")) {
            this.appCategory = appCategory;
        }
    }

    /**
     * Saves the currently selected settings with the values saved by the bean.
     *
     * @return the setting page to display changes.
     */
    public String saveSetting() {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Setting setting = new Setting(accessScore, new Date(), osWeight, rootedWeight, debugWeight, unknownSourcesWeight, lowRiskApp, mediumRiskApp, highRiskApp, blockedApp);
        session.save(setting);
        session.getTransaction().commit();
        session.close();
        return "settings.xhtml";
    }

    /**
     * Adds a new blacklisted application to our list.
     *
     * @return the setting page to display changes.
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
     * Getter for the newest setting stored in our database based on the
     * [SettingDate] field.
     *
     * @return the newest setting.
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
     * Removes a blacklisted application from our list and then navigates to the
     * settings page.
     *
     * @param app is the blacklisted application we wish to remove from our
     * list.
     * @return the settings page to display changes.
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
     * Getter for all the settings entries in our list.
     *
     * @return the list
     */
    public List<Setting> getSettings() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Setting");
        settings = query.list();
        return settings;
    }

    /**
     * Getter for all the #Scanresult entries who were allowed access in our
     * list.
     *
     * @return the list of #Scanresults
     */
    public List<Scanresult> getAllowedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 1");
        allowedScans = query.list();
        return allowedScans;
    }

    /**
     * Getter for all the #Scanresult entries who were not allowed access in our
     * list.
     *
     * @return the list of #Scanresults
     */
    public List<Scanresult> getDeniedScans() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Scanresult where accessAllowed = 0");
        deniedScans = query.list();
        return deniedScans;
    }

    /**
     * Viewer of a specific setting based on its id.
     *
     * @param id is the unique identifier used to find the settings entry in our
     * list.
     * @return the specificSetting page to display that specific settings and
     * its components.
     */
    public String showSetting(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        specificSetting = (Setting) session.get(Setting.class, id);
        return "specificSetting.xhtml";
    }

    /**
     * Getter for a specific setting.
     *
     * @return the specificSetting.
     */
    public Setting getSpecificSetting() {
        return specificSetting;
    }
}
