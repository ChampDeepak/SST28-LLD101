package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

/**
 * INTENTION: A ticket should be an immutable record-like object.
 *
 * CURRENT STATE (BROKEN ON PURPOSE):
 * - mutable fields
 * - multiple constructors
 * - public setters
 * - tags list can be modified from outside
 * - validation is scattered elsewhere
 *
 * TODO (student): refactor to immutable + Builder.
 */
public class IncidentTicket {

    private final String id;
    private final String reporterEmail;
    private final String title;

    private final String description;
    private final String priority;       // LOW, MEDIUM, HIGH, CRITICAL
    private final List<String> tags;     // mutable leak
    private final String assigneeEmail;
    private final boolean customerVisible;
    private final Integer slaMinutes;    // optional
    private final String source;         // e.g. "CLI", "WEBHOOK", "EMAIL"

    private IncidentTicket(Builder b) {
        this.id = b.id;
        this.reporterEmail = b.reporterEmail;
        this.title = b.title;
        this.description = b.description;
        this.priority = b.priority;       // LOW, MEDIUM, HIGH, CRITICAL
        this.tags = List.copyOf(b.tags);     // mutable leak
        this.assigneeEmail = b.assigneeEmail;
        this.customerVisible = b.customerVisible;
        this.slaMinutes = b.slaMinutes;    // optional
        this.source = b.source;    
    }

    // Getters
    public String getId() { return id; }
    public String getReporterEmail() { return reporterEmail; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getPriority() { return priority; }
    public List<String> getTags() { return List.copyOf(tags); } // BROKEN: leaks internal list
    public String getAssigneeEmail() { return assigneeEmail; }
    public boolean isCustomerVisible() { return customerVisible; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getSource() { return source; }

    // Setters (BROKEN: should not exist after refactor)
    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }

    public static class Builder {
        private String id;
        private String reporterEmail;
        private String title;
        private String description;
        private String priority;       // LOW, MEDIUM, HIGH, CRITICAL
        private List<String> tags = new ArrayList<>();     // mutable leak
        private String assigneeEmail;
        private boolean customerVisible;
        private Integer slaMinutes;    // optional
        private String source;   

        public Builder id(String id)          { this.id = id; return this; }
        public Builder reporterEmail(String v){ this.reporterEmail = v; return this; }
        public Builder title(String v)        { this.title = v; return this; }
        public Builder description(String v)  { this.description = v; return this; }
        public Builder priority(String v)     { this.priority = v; return this; }
        public Builder tags(List<String> v)   { this.tags = new ArrayList<>(v); return this; }
        public Builder assigneeEmail(String v){ this.assigneeEmail = v; return this; }
        public Builder customerVisible(boolean v) { this.customerVisible = v; return this; }
        public Builder slaMinutes(Integer v)  { this.slaMinutes = v; return this; }
        public Builder source(String v)       { this.source = v; return this; }

        public IncidentTicket build() {
            Validation.requireTicketId(id);                          
            Validation.requireEmail(reporterEmail, "reporterEmail"); 
            Validation.requireNonBlank(title, "title");         
            Validation.requireMaxLen(title, 80, "title");       
            Validation.requireOneOf(priority, "priority",
                "LOW", "MEDIUM", "HIGH", "CRITICAL");
            if (assigneeEmail != null)
                Validation.requireEmail(assigneeEmail, "assigneeEmail");
            Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes"); 

            return new IncidentTicket(this);
        }
    }
}
