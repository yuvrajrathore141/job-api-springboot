package com.yuvraj.jobapi.service;
import com.yuvraj.jobapi.model.Job;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class JobService {
        //ArrayList for object Storage
        ArrayList<Job> jobs = new ArrayList<Job>();

        //DemoData using constructor
        public JobService() {
            jobs.add(new Job(1, "Java Developer", "Backend Developer", 50000, "Techcorp", "Delhi"));
            jobs.add(new Job(2, "Frontend Developer", "React Development", 45000, "WebSolutions", "Mumbai"));
            jobs.add(new Job(3, "Full Stack Developer", "Frontend + Backend", 70000, "CodeBase", "Bangalore"));
        }

        //addJob Method
        public void addJob(Job job) {
            jobs.add(job);
        }
        //getAllJobs Method
        public ArrayList<Job> getAllJobs(){
            return jobs;
        }
        //getJobById Method
        public Job getJobById(int id){
            for(Job job : jobs){
                if(id == job.getJobId()){
                    return job;
                }

            }
            return null;
        }
        //deleteJobById Method
        public void deleteJobById(int id){
            jobs.removeIf(job -> id == job.getJobId());
        }
        //updateJobById Method
        public void updateJob(Job job){
            for(Job job1 : jobs){
                if(job.getJobId() == job1.getJobId()){
                    job1.setJobId(job.getJobId());
                    job1.setJobTitle(job.getJobTitle());
                    job1.setJobDescription(job.getJobDescription());
                    job1.setCompanyAddress(job.getCompanyAddress());
                    job1.setCompanyName(job.getCompanyName());
                    job1.setSalary(job.getSalary());
                }
            }
        }
        //searchJobByName Method
        public Job searchJobByName(String name){
            for(Job job : jobs){
                if(job.getJobTitle().equals(name)){
                    return job;
                }
            }
            return null;
        }
}
