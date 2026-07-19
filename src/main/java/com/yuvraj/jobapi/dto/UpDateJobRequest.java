package com.yuvraj.jobapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class UpDateJobRequest {
    @Positive
    private int jobId;
    @NotBlank
    private String jobTitle;
    @NotBlank
    private String jobDescription;
    @NotNull
    @Positive
    private Double salary;
    @NotBlank
    private String companyName;
    @NotBlank
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
