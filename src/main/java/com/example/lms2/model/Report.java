package com.example.lms2.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String reportType;
    private String parameters;
    private Date generationDate;

    private int overdueCount;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public Date getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Date generationDate) {
        this.generationDate = generationDate;
    }

    public int getOverdueCount() {
        return overdueCount;
    }

    public void setOverdueCount(int overdueCount) {
        this.overdueCount = overdueCount;
    }
}
