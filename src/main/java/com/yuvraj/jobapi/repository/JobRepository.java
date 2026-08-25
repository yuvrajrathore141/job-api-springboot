package com.yuvraj.jobapi.repository;

import com.yuvraj.jobapi.model.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Page<Job> findByJobTitleContainingIgnoreCase(String jobTitle, Pageable pageable);
}