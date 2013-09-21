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

    public String getSummary(int rooted, int debug, int unknown, int os, String apps, int appScore, int total) {
        String summary = "";
        if (rooted != 0) {
            summary += "Rooted device: " + rooted + "\r\n";
        }
        if (debug != 0) {
            summary += "USB Debugging Enabled: " + debug + "\r\n";
        }
        if (unknown != 0) {
            summary += "Applications from unknown sources allowed: " + unknown + "\r\n";
        }
        if (os != 0)
        {
            summary += "Operating System Version: " +  os + "\r\n";
        }
        if (apps.length() != 0)
            summary += "Blacklisted applications installed: " + appScore + "\r\n(" + apps + ")\r\n";
        summary += "Total Score: " + total;
        return summary;
    }
}
