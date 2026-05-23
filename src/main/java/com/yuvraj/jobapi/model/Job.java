package com.yuvraj.jobapi.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
public class Job {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        private int jobId;

        private String jobTitle;
        private String jobDescription;
        private double salary;
        private String companyName;
        private String companyAddress;



        public Job() {}




        //GetJobValue
        public int getJobId() {
            return jobId;
        }
        public String getJobTitle() {
            return jobTitle;
        }
        public String getJobDescription() {
            return jobDescription;
        }
        public double getSalary() {
            return salary;
        }
        public String getCompanyName() {
            return companyName;
        }
        public String getCompanyAddress() {
            return companyAddress;
        }


        //SetJobValue
        public void setJobId(Integer id) {
            this.jobId = id;
        }
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


        @Override
        public String toString() {
            return "ID: " + jobId + " Title: " + jobTitle + " Description: " + jobDescription +" Salary: " + salary + " Company: " + companyName + " Address: " + companyAddress;
        }
}
