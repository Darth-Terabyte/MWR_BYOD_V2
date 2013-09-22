/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import org.hibernate.Session;

@ManagedBean(name = "out")
@SessionScoped
public class OutputBean {

    private Session session;
    private DatabaseJSFManagedBean b;
    private int rootedWeight, currRootedWeight;
    private int debugWeight, currDebugWeight;
    private int unknownSourcesWeight, currUnknownSourcesWeight;
    private int osWeight, currOSWeight;
    private int lowRiskApp, currLowRiskAppWeight;
    private int mediumRiskApp, currMediumRiskAppWeight;
    private int highRiskApp, currHighRiskAppWeight;
    private int blockedApp, currBlockedAppWeight;
    private int accessScore, currAccessScore;
    private Boolean rootedChanged, debugChanged, USChanged, OSChanged,
            lowChanged, medChanged, highChanged, blockChanged, accessChanged;

    public OutputBean() {
        session = HibernateUtil.getSessionFactory().openSession();
        b = new DatabaseJSFManagedBean();
        rootedWeight = b.getRootedWeight();
        debugWeight = b.getDebugWeight();
        unknownSourcesWeight = b.getUnknownSourcesWeight();
        osWeight =b.getOsWeight();
        lowRiskApp = b.getLowRiskApp();
        mediumRiskApp = b.getMediumRiskApp();
        highRiskApp = b.getHighRiskApp();
        blockedApp = b.getBlockedApp();
        accessScore = b.getAccessScore();
    }

    public int getCurrentRootedWeight() {
        return currRootedWeight;
    }

    public int getCurrentDebuggingEnabledWeight() {
        return currDebugWeight;
    }

    public int getCurrentUnknownSourcesEnabledWeight() {
        return currUnknownSourcesWeight;
    }

    public int getCurrentOSWeight() {
        return currOSWeight;
    }

    public int getCurrentLowRiskAppWeight() {
        return currLowRiskAppWeight;
    }

    public int getCurrentMedRiskAppWeight() {
        return currMediumRiskAppWeight;
    }

    public int getCurrentHighRiskAppWeight() {
        return currHighRiskAppWeight;
    }

    public int getCurrentBlockedAppWeight() {
        return currBlockedAppWeight;
    }

    public int getCurrentAccessScore() {
        return currAccessScore;
    }

    public void setCurrentRootedWeight(int score) {
        currRootedWeight = score;
    }

    public void setCurrentDebuggingEnabledWeight(int score) {
        currDebugWeight = score;
    }

    public void setCurrentUnknownSourcesEnabledWeight(int score) {
        currUnknownSourcesWeight = score;
    }

    public void setCurrentOSWeight(int score) {
        currOSWeight = score;
    }

    public void setCurrentLowRiskAppWeight(int score) {
        currLowRiskAppWeight = score;
    }

    public void setCurrentMedRiskAppWeight(int score) {
        currMediumRiskAppWeight = score;
    }

    public void setCurrentHighRiskAppWeight(int score) {
        currHighRiskAppWeight = score;
    }

    public void setCurrentBlockedAppWeight(int score) {
        currBlockedAppWeight = score;
    }

    public void setCurrentAccessScore(int score) {
        currAccessScore = score;
    }

    public void compareAndSaveWeights() {
        if (rootedWeight == currRootedWeight) {
            rootedChanged = false;
        } else {
            rootedChanged = true;
        }
        if (debugWeight == currDebugWeight) {
            debugChanged = false;
        } else {
            debugChanged = true;
        }
        if (unknownSourcesWeight == currUnknownSourcesWeight) {
            USChanged = false;
        } else {
            USChanged = true;
        }
        if (osWeight == currOSWeight) {
            OSChanged = false;
        } else {
            OSChanged = true;
        }
        if (lowRiskApp == currLowRiskAppWeight) {
            lowChanged = false;
        } else {
            lowChanged = true;
        }
        if (mediumRiskApp == currMediumRiskAppWeight) {
            medChanged = false;
        } else {
            medChanged = true;
        }
        if (highRiskApp == currHighRiskAppWeight) {
            highChanged = false;
        } else {
            highChanged = true;
        }
        if (blockedApp == currBlockedAppWeight) {
            blockChanged = false;
        } else {
            blockChanged = true;
        }
        if (accessScore == currAccessScore) {
            accessChanged = false;
        } else {
            accessChanged = true;
        }
    }
}
