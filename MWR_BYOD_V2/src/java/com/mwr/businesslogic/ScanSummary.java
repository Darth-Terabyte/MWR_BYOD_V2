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

    public String getSummary(int rooted, int debug, int unknown, int os, String apps) {
        String summary = "";
        if (rooted != 0) {
            summary += "This device is rooted.\r\n";
        }
        if (debug != 0) {
            summary += "USB Debugging is enabled on this device.\r\n";
        }
        if (unknown != 0) {
            summary += "Applications from unknown sources are allowed on this device.\r\n";
        }
        if (os != 0)
        {
            summary += "This device's Android OS version may be outdated";
        }
        summary += "The following blacklisted applications are installed: " + apps + ".\r\n";
        return summary;
    }
}
