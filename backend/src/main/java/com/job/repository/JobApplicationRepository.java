package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.model.JobApplicationDetails;
import com.job.model.JobDetails;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplicationDetails, Long>{

}