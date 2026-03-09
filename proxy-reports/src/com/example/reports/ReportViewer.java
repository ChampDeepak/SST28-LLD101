package com.example.reports;

import com.example.reports.reports.Report;

/**
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - Viewer depends directly on concrete ReportFile
 * - No Proxy involved
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}
