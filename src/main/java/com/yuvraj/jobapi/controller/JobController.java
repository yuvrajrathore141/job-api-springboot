package com.yuvraj.jobapi.controller;
import com.yuvraj.jobapi.dto.CreateJobRequest;
import com.yuvraj.jobapi.model.Job;
import com.yuvraj.jobapi.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService service;


    public JobController(JobService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        List<Job> job = service.getAllJobs();
        return ResponseEntity.ok(job);
    }

    @GetMapping("/{userid}")
    public ResponseEntity<Job> getJobsByUserId(@PathVariable Integer userid) {
        Job job = service.findById(userid);
        if(job == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody CreateJobRequest createJobRequest) {
        Job jobVar = service.addJob(createJobRequest);
        if(jobVar == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(jobVar);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<Boolean> deleteJob(@PathVariable String userid) {
        Boolean delId = service.deleteJobById(Integer.parseInt(userid));
        if(delId == false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Boolean> updateJob(@RequestBody Job job) {
         Boolean upDate = service.updateJob(job);
        if(upDate == false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(upDate);
    }
}
