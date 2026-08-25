package com.yuvraj.jobapi.controller;
import com.yuvraj.jobapi.dto.AllJobResponse;
import com.yuvraj.jobapi.dto.CreateJobRequest;
import com.yuvraj.jobapi.dto.JobDetailResponse;
import com.yuvraj.jobapi.dto.UpDateJobRequest;
import com.yuvraj.jobapi.service.JobService;
import jakarta.validation.Valid;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService service;


    public JobController(JobService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<AllJobResponse>> getAllJobs(
            @PageableDefault(page = 0, size = 3) Pageable pageable) {
        return ResponseEntity.ok(service.getAllJobs(pageable));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<JobDetailResponse> getJobsByUserId(@PathVariable Integer userid) {
        JobDetailResponse job = service.findById(userid);
        if(job == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(job);
    }

    @PostMapping
    public ResponseEntity<JobDetailResponse> createJob(@Valid @RequestBody CreateJobRequest createJobRequest) {
        JobDetailResponse jobVar = service.addJob(createJobRequest);
        if(jobVar == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(jobVar);
    }

    @DeleteMapping("/{jobid}")
    public ResponseEntity<Boolean> deleteJob(@PathVariable String jobid) {
        Boolean delId = service.deleteJobById(Integer.parseInt(jobid));
        if(delId == false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<Boolean> updateJob(@Valid @RequestBody UpDateJobRequest upDateJobRequest) {
         Boolean upDate = service.updateJob(upDateJobRequest);
        if(upDate == false){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(upDate);
    }

    @GetMapping("/search")
    public Page<AllJobResponse> getJobByTitle(@RequestParam("title") String jobTitle, @PageableDefault(page= 0, size= 3) Pageable pageable) {
        return service.searchJobByName(jobTitle, pageable);
    }
}
