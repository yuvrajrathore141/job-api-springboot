package com.yuvraj.jobapi.service;
import com.yuvraj.jobapi.dto.AllJobResponse;
import com.yuvraj.jobapi.dto.CreateJobRequest;
import com.yuvraj.jobapi.dto.JobDetailResponse;
import com.yuvraj.jobapi.dto.UpDateJobRequest;
import com.yuvraj.jobapi.model.Job;
import com.yuvraj.jobapi.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class JobService {

        private JobRepository jobRepository;
        public JobService(JobRepository jobRepository) {this.jobRepository = jobRepository;}

        //getAllJobs
        public List<AllJobResponse> getAllJobs() {
            List<AllJobResponse> jobs = new ArrayList<>();
            List<Job> jobList = jobRepository.findAll();
            for (Job job : jobList) {
                jobs.add(toGetAllJobs(job));
            }
            return jobs;
        }
        public AllJobResponse toGetAllJobs(Job job) {
            AllJobResponse jobResponse = new AllJobResponse();
            jobResponse.setJobId(job.getJobId());
            jobResponse.setJobTitle(job.getJobTitle());
            jobResponse.setCompanyName(job.getCompanyName());
            jobResponse.setSalary(job.getSalary());
            return jobResponse;
        }
        public JobDetailResponse tojobDetailResponse(Job job){
            JobDetailResponse jobDetailResponse = new JobDetailResponse();
            jobDetailResponse.setJobId(job.getJobId());
            jobDetailResponse.setJobTitle(job.getJobTitle());
            jobDetailResponse.setJobDescription(job.getJobDescription());
            jobDetailResponse.setSalary(job.getSalary());
            jobDetailResponse.setCompanyName(job.getCompanyName());
            jobDetailResponse.setCompanyAddress(job.getCompanyAddress());
            return jobDetailResponse;
        }
        public Job tocreateJob(CreateJobRequest createJobRequest) {
            Job job = new Job();
            job.setJobTitle(createJobRequest.getJobTitle());
            job.setJobDescription(createJobRequest.getJobDescription());
            job.setSalary(createJobRequest.getSalary());
            job.setCompanyName(createJobRequest.getCompanyName());
            job.setCompanyAddress(createJobRequest.getCompanyAddress());
            return job;
        }
        public Job toupdateJob(UpDateJobRequest upDateJobRequest) {
            Job job = new Job();
            job.setJobTitle(upDateJobRequest.getJobTitle());
            job.setJobDescription(upDateJobRequest.getJobDescription());
            job.setSalary(upDateJobRequest.getSalary());
            job.setCompanyName(upDateJobRequest.getCompanyName());
            job.setCompanyAddress(upDateJobRequest.getCompanyAddress());
            return job;
        }
        //addJob
        public JobDetailResponse addJob(CreateJobRequest createJobRequest) {
            return tojobDetailResponse(
                    jobRepository.save(
                            tocreateJob(createJobRequest)
                    )
            );
        }

        //findById
        public JobDetailResponse findById(Integer id) {
            return tojobDetailResponse(jobRepository.findById(id).orElse(null));
        }


        //deleteJobById Method
        public Boolean deleteJobById(int id){
            if(jobRepository.existsById(id)){
                jobRepository.deleteById(id);
                return true;
            }
            return false;
        }
        //updateJobById Method
        public Boolean updateJob(UpDateJobRequest  upDateJobRequest) {
            Job job = toupdateJob(upDateJobRequest);
            if(jobRepository.existsById(job.getJobId())){
                jobRepository.save(job);
                return true;
            }
            return false;
        }
        //searchJobByName Method
        public Job searchJobByName(String name){
            return jobRepository.findByJobTitle(name);
        }
}
