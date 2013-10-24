/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mwr.businesslogic;

/**
 *
 * @author LuxInTenebris
 */
public class ScanSummary {

    /**
     * Compiles a summary of a device's scan based on the scores
     *
     * @param rooted Score based on setting: Device rooted
     * @param debug Score based on setting: USB Debugging enabled
     * @param unknown Score based on setting: Unknown sources available
     * @param api_level Score based on setting: Android API level
     * @param apps List of blacklisted applications installed
     * @param appScore Score based on blacklisted applications installed
     * @param total Total score for the scan
     * @return Returns the summary of a scan as a string
     */
    public String getSummary(int rooted, int debug, int unknown, int api_level, String apps, int appScore, int total) {
        String summary = "";
        if (rooted != 0) {
            summary += "Device is rooted;";
        }
        if (debug != 0) {
            summary += "USB Debugging is enabled;";
        }
        if (unknown != 0) {
            summary += "Applications from unknown sources are allowed;";
        }
        if (api_level != 0) {
            summary += "Android version is outdated;";
        }
        if (apps.length() != 0 && !apps.equals("None")) {
            summary += "Blacklisted applications installed: " + apps + ";";
        }
        summary += "Total Score: " + total;
        return summary;
    }
}
