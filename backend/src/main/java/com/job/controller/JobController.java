package com.job.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.exception.ResourceNotFoundException;
import com.job.model.JobDetails;
import com.job.repository.JobRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class JobController {
	
	@Autowired
	private JobRepository jobRepository;
	
	@GetMapping("/jobs")
	public List<JobDetails> getAllJobs() {
		return jobRepository.findAll();
	}

	@GetMapping("/jobs/{id}")
	public ResponseEntity<JobDetails> getJobById(@PathVariable(value = "id") Long jobId)
			throws ResourceNotFoundException {
		JobDetails jobDetails = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("jobDetails not found for this id :: " + jobId));
		return ResponseEntity.ok().body(jobDetails);
	}

	@PostMapping("/jobs")
	public JobDetails createJob(@Valid @RequestBody JobDetails jobDetails) {
		return jobRepository.save(jobDetails);
	}

	@PutMapping("/jobs/{id}")
	public ResponseEntity<JobDetails> updateJob(@PathVariable(value = "id") Long jobId,
			@Valid @RequestBody JobDetails jobUpdatedDetails) throws ResourceNotFoundException {
		JobDetails jobDetails = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("jobDetails not found for this id :: " + jobId));

		jobDetails.setJobDescription(jobUpdatedDetails.getJobDescription());
		jobDetails.setJobTitle(jobUpdatedDetails.getJobTitle());
		jobDetails.setWageRange(jobUpdatedDetails.getWageRange());
		final JobDetails updatedJob = jobRepository.save(jobDetails);
		return ResponseEntity.ok(updatedJob);
	}

	@DeleteMapping("/jobs/{id}")
	public Map<String, Boolean> deleteJob(@PathVariable(value = "id") Long jobId)
			throws ResourceNotFoundException {
		JobDetails jobDetails = jobRepository.findById(jobId)
				.orElseThrow(() -> new ResourceNotFoundException("jobDetails not found for this id :: " + jobId));

		jobRepository.delete(jobDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
