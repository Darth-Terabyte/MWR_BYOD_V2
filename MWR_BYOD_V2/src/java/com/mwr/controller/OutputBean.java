/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mwr.database.*;
import java.util.ArrayList;
import java.util.List;
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
        Setting s = b.getLatestSetting();
        
        rootedWeight = s.getRootedWeight();
        debugWeight = s.getDebugWeight();
        unknownSourcesWeight = s.getUnknownSourcesWeight();
        osWeight =s.getOsweight();
        lowRiskApp = s.getLowRiskApp();
        mediumRiskApp = s.getMediumRiskApp();
        highRiskApp = s.getHighRiskApp();
        blockedApp = s.getBlockedApp();
        accessScore = s.getAccessScore();
        
        currRootedWeight = rootedWeight;
        currDebugWeight = debugWeight;
        currUnknownSourcesWeight = unknownSourcesWeight;
        currOSWeight = osWeight;
        currLowRiskAppWeight = lowRiskApp;
        currMediumRiskAppWeight = mediumRiskApp;
        currHighRiskAppWeight = highRiskApp;
        currBlockedAppWeight = blockedApp;
        currAccessScore = accessScore;
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
    
    public int getWeightSystemTotal() {
        int score = 0;
        List<Integer> weights = new ArrayList<Integer>();

        weights.add(currAccessScore);
        weights.add(currDebugWeight);
        weights.add(currOSWeight);
        weights.add(currRootedWeight);
        weights.add(currUnknownSourcesWeight);

        for (int i = 0; i < weights.size(); i++) {
            score += weights.get(i);
        }

        return score;
    }

    public int getWeightAppsTotal() {
        int score = 0;
        List<Integer> weights = new ArrayList<Integer>();

        weights.add(currLowRiskAppWeight);
        weights.add(currMediumRiskAppWeight);
        weights.add(currHighRiskAppWeight);
        weights.add(currBlockedAppWeight);

        for (int i = 0; i < weights.size(); i++) {
            score += weights.get(i);
        }

        return score;
    }
    
    
}
