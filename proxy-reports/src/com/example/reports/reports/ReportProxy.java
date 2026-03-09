package com.example.reports.reports;

import com.example.reports.AccessControl;
import com.example.reports.User;

/**
 * TODO (student):
 * Implement Proxy responsibilities here:
 * - access check
 * - lazy loading
 * - caching of RealReport within the same proxy
 */
public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private RealReport realReport; 
    // private final AccessControl accessControl = new AccessControl();

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
        
    }

    @Override
    public void display(User user) {
        // Starter placeholder: intentionally incorrect.
        // Students should remove direct real loading on every call.
        if(AccessControl.canAccess(user, classification))
        {
            if(this.realReport==null)  this.realReport = new RealReport(reportId, title, classification);
            this.realReport.display(user);
        }
        else System.out.println("User with \"" + user.getRole() + "\" role can not access \"" + classification + "\" files.");
    }
}
