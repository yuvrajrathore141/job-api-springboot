package com.yuvraj.jobapi.dto;

public class UpDateJobRequest {
    private int jobId;
    private String jobTitle;
    private String jobDescription;
    private Double salary;
    private String companyName;
    private String companyAddress;

    public UpDateJobRequest(){}

    //GetJobValue
    public int getJobId() {return jobId;}
    public String getJobTitle() {
        return jobTitle;
    }
    public String getJobDescription() {
        return jobDescription;
    }
    public Double getSalary() {
        return salary;
    }
    public String getCompanyName() {
        return companyName;
    }
    public String getCompanyAddress() {
        return companyAddress;
    }
}
