package com.yuvraj.jobapi.repository;

import com.yuvraj.jobapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findByJobTitle(String jobTitle);
}