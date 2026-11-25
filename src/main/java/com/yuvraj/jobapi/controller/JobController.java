package com.yuvraj.jobapi.controller;
import com.yuvraj.jobapi.dto.AllJobResponse;
import com.yuvraj.jobapi.dto.CreateJobRequest;
import com.yuvraj.jobapi.dto.JobDetailResponse;
import com.yuvraj.jobapi.dto.UpDateJobRequest;
import com.yuvraj.jobapi.service.JobService;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;



@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService service;


    public JobController(JobService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<Page<AllJobResponse>> getAllJobs(
            @RequestParam(required = false, defaultValue = "1") int PageNumber,
            @RequestParam(required = false, defaultValue = "5") int PageSize,
            @RequestParam(required = false, defaultValue = "jobId") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("ASC")){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }

        return ResponseEntity.ok(service.getAllJobs(PageRequest.of(PageNumber-1, PageSize, sort)));
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


}
