/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.businesslogic;

/**
 *
 * @author madenem
 */
public class ScanSummary {

    /**
     *
     * @param rooted
     * @param debug
     * @param unknown
     * @param os
     * @param api_level
     * @param apps
     * @param appScore
     * @param total
     * @return
     */
    public String getSummary(int rooted, int debug, int unknown, int os, int api_level, String apps, int appScore, int total) {
        String summary = "";
        if (rooted != 0) {
            summary += "Device is rooted";
        }
        if (debug != 0) {
            summary += "USB Debugging is enabled;";
        }
        if (unknown != 0) {
            summary += "Applications from unknown sources are allowed;";
        }
        if (os != 0)
        {
            summary += "Android API Level: " +  api_level + ";";
        }
        if (apps.length() != 0)
            summary += "Blacklisted applications installed: " + apps + ";";
        summary += "Total Score: " + total;
        return summary;
    }
}
