package com.yuvraj.jobapi.dto;

import com.yuvraj.jobapi.model.Job;

public class AllJobResponse {
    private int jobId;
    private String jobTitle;
    private String companyName;
    private Double salary;

    public AllJobResponse() {}

    public int getJobId() {return jobId;}
    public String getJobTitle() {
        return jobTitle;
    }
    public Double getSalary() {
        return salary;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setJobId(int jobId) {this.jobId = jobId;}
    public void setJobTitle(String jobTitle) {this.jobTitle = jobTitle;}
    public void setSalary(Double salary) {this.salary = salary;}
    public void setCompanyName(String companyName) {this.companyName = companyName;}
}

