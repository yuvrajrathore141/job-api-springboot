package com.yuvraj.jobapi.controller;
import com.yuvraj.jobapi.model.Job;
import com.yuvraj.jobapi.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JobController {
    private JobService service;


    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping("/jobs")
    public ArrayList<Job> getAllJobs() {
        return service.getAllJobs();
    }

    @GetMapping("/jobs/{userid}")
    public Job getJobsByUser(@PathVariable String userid) {
        return service.getJobById(Integer.parseInt(userid));
    }

    @PostMapping("/jobs")
    public void createJob(@RequestBody Job job) {
        service.addJob(job);
    }

    @DeleteMapping("/jobs/{userid}")
    public void deleteJob(@PathVariable String userid) {
        service.deleteJobById(Integer.parseInt(userid));
    }

    @PutMapping("/jobs")
    public void updateJob(@RequestBody Job job) {
        service.updateJob(job);
    }
}
