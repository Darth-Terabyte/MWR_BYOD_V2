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
import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

@ManagedBean(name = "out")
@SessionScoped
public class OutputBean {

    private Session session;
    private int rootedWeight, currRootedWeight;
    private int debugWeight, currDebugWeight;
    private int unknownSourcesWeight, currUnknownSourcesWeight;
    private int osWeight, currOSWeight;
    private int lowRiskApp, currLowRiskAppWeight;
    private int mediumRiskApp, currMediumRiskAppWeight;
    private int highRiskApp, currHighRiskAppWeight;
    private int blockedApp, currBlockedAppWeight;
    private int accessScore, currAccessScore;

    public OutputBean() {

        session = HibernateUtil.getSessionFactory().openSession();

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
         currOSWeight  = score;
    }

    public void setCurrentLowRiskAppWeight(int score) {
        currLowRiskAppWeight  = score;
    }

    public void setCurrentMedRiskAppWeight(int score) {
        currMediumRiskAppWeight  = score;
    }

    public void setCurrentHighRiskAppWeight(int score) {
        currHighRiskAppWeight  = score;
    }

    public void setCurrentBlockedAppWeight(int score) {
        currBlockedAppWeight  = score;
    }

    public void setCurrentAccessScore(int score) {
        currAccessScore  = score;
    }
    
    public void compareWeights()
    {
    if (rootedWeight == currRootedWeight)
    if (debugWeight == currDebugWeight)
    if (unknownSourcesWeight == currUnknownSourcesWeight)
    if (osWeight == currOSWeight)
    if (lowRiskApp == currLowRiskAppWeight)
    if (mediumRiskApp == currMediumRiskAppWeight)
    if (highRiskApp == currHighRiskAppWeight)
    if (blockedApp == currBlockedAppWeight)
    if (accessScore == currAccessScore)
        System.out.println("Yay!");
    }
    
}
