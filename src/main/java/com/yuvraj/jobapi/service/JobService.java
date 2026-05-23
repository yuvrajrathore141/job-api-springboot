package com.yuvraj.jobapi.service;
import com.yuvraj.jobapi.model.Job;
import com.yuvraj.jobapi.repository.JobRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class JobService {

        private JobRepository jobRepository;
        public JobService(JobRepository jobRepository) {this.jobRepository = jobRepository;}

        //getAllJobs
        public List<Job> getAllJobs() {
            return (List<Job>) jobRepository.findAll();
        }

        //addJob
        public Job addJob(Job job) {
            return jobRepository.save(job);
        }

        //findById
        public Job findById(Integer id) {
            return jobRepository.findById(id).orElse(null);
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
        public Boolean updateJob(Job job){
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
