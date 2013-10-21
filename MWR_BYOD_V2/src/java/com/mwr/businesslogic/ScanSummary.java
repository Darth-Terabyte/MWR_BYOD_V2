/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.businesslogic;

/**
 * @version 2.0
 * @author LuxInTenebris
 */
public class ScanSummary {

    /**
     *
     * @param rooted
     * @param usbDebuggingEnabled
     * @param unknownSources
     * @param os
     * @param apiLevel
     * @param listOfApps
     * @param appScore
     * @param totalScore
     * @return Returns a string to the device of the scan results.
     */
    public String getSummary(int rooted, int usbDebuggingEnabled, int unknownSources, int os, int apiLevel, String listOfApps, int appScore, int totalScore) {
        String summary = "";
        if (rooted != 0) {
            summary += "Device is rooted";
        }
        if (usbDebuggingEnabled != 0) {
            summary += "USB Debugging is enabled;";
        }
        if (unknownSources != 0) {
            summary += "Applications from unknown sources are allowed;";
        }
        if (os != 0) {
            summary += "Android API Level: " + apiLevel + ";";
        }
        if (listOfApps.length() != 0) {
            summary += "Blacklisted applications installed: " + listOfApps + ";";
        }
        summary += "Total Score: " + totalScore;
        return summary;
    }
}
