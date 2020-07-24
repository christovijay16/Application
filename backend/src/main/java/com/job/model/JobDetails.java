package com.job.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jobdetails")
public class JobDetails {

	private long id;
	private String jobTitle;
	private String jobDescription;
	private String wageRange;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "job_title", nullable = false)
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	
	@Column(name = "job_description", nullable = false)
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	@Column(name = "wage_range", nullable = false)
	public String getWageRange() {
		return wageRange;
	}
	public void setWageRange(String wageRange) {
		this.wageRange = wageRange;
	}
	
	
	
}
