package com.yuvraj.jobapi.repository;

import com.yuvraj.jobapi.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Integer> {
    //Job findByJobTitle(String jobTitle);
    List<Job> findByJobTitleContainingIgnoreCase(String jobTitle);
}