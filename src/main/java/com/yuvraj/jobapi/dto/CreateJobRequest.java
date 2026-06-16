package com.yuvraj.jobapi.dto;

public class CreateJobRequest {
    private String jobTitle;
    private String jobDescription;
    private Double salary;
    private String companyName;
    private String companyAddress;

    public CreateJobRequest(){}

    //GetJobValue
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


    //SetJobValue
    public void setJobTitle(String title) {
        this.jobTitle = title;
    }
    public void setJobDescription(String description) {
        this.jobDescription = description;
    }
    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

}
