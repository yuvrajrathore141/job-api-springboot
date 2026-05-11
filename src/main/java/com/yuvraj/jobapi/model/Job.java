package com.yuvraj.jobapi.model;

public class Job {

        private int jobId;
        private String jobTitle;
        private String jobDescription;
        private double salary;
        private String companyName;
        private String companyAddress;

        public Job(int id, String title, String description, double salary, String companyName, String companyAddress) {
            jobId = id;
            jobTitle = title;
            jobDescription = description;
            this.salary = salary;
            this.companyName = companyName;
            this.companyAddress = companyAddress;
        }




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
        public void setJobId(int id) {
            this.jobId = id;
        }
        public void setJobTitle(String title) {
            this.jobTitle = title;
        }
        public void setJobDescription(String description) {
            this.jobDescription = description;
        }
        public void setSalary(double salary) {
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
