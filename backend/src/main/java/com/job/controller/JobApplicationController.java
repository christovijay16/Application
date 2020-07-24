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
import com.job.model.JobApplicationDetails;
import com.job.model.JobDetails;
import com.job.repository.JobApplicationRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class JobApplicationController {
	
	@Autowired
	private JobApplicationRepository jobApplicationRepository;
	
	@GetMapping("/jobApplications")
	public List<JobApplicationDetails> getAllJobApplications() {
		return jobApplicationRepository.findAll();
	}

	@GetMapping("/jobApplications/{id}")
	public ResponseEntity<JobApplicationDetails> getJobApplicationById(@PathVariable(value = "id") Long jobApplicationId)
			throws ResourceNotFoundException {
		JobApplicationDetails jobApplicationDetails = jobApplicationRepository.findById(jobApplicationId)
				.orElseThrow(() -> new ResourceNotFoundException("jobDetails not found for this id :: " + jobApplicationId));
		return ResponseEntity.ok().body(jobApplicationDetails);
	}

	@PostMapping("/jobApplications")
	public JobApplicationDetails createApplicationJob(@Valid @RequestBody JobApplicationDetails jobApplicationDetails) {
		return jobApplicationRepository.save(jobApplicationDetails);
	}

	@PutMapping("/jobApplications/{id}")
	public ResponseEntity<JobApplicationDetails> updateJob(@PathVariable(value = "id") Long jobApplicationId,
			@Valid @RequestBody JobApplicationDetails jobApplicationUpdatedDetails) throws ResourceNotFoundException {
		JobApplicationDetails jobApplicationDetails = jobApplicationRepository.findById(jobApplicationId)
				.orElseThrow(() -> new ResourceNotFoundException("jobDetails not found for this id :: " + jobApplicationId));

		jobApplicationDetails.setVendorRepEmail(jobApplicationUpdatedDetails.getVendorRepEmail());
		jobApplicationDetails.setVendorRepName(jobApplicationUpdatedDetails.getVendorRepName());		
		final JobApplicationDetails updatedJobApplication = jobApplicationRepository.save(jobApplicationDetails);
		return ResponseEntity.ok(updatedJobApplication);
	}

	@DeleteMapping("/jobApplications/{id}")
	public Map<String, Boolean> deleteJobApplication(@PathVariable(value = "id") Long jobApplicationId)
			throws ResourceNotFoundException {
		JobApplicationDetails jobApplicationDetails = jobApplicationRepository.findById(jobApplicationId)
				.orElseThrow(() -> new ResourceNotFoundException("jobApplicationDetails not found for this id :: " + jobApplicationId));

		jobApplicationRepository.delete(jobApplicationDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
	@GetMapping("/jobApplications/sendReviewRequest")
	public List<JobApplicationDetails> sendReviewRequest() {
		return jobApplicationRepository.findAll();
	}
	
	@GetMapping("/jobApplications/setupInterview")
	public List<JobApplicationDetails> setupInterview() {
		return jobApplicationRepository.findAll();
	}


}
