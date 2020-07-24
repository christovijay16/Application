package com.job.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "jobappdetails")
public class JobApplicationDetails {

	private long id;
	private Date dateRecieved;
	private String vendorCompany;
	private String vendorRepName;
	private String vendorRepEmail;
	private String candidateName;
	private int yrsOfExp;
	private String gender;
	private String decision;
	private Date dateReviewed;
	private Date dateTechPhoneInterview;
	private String techPhoneinterviewStatus;
	private Date dateFaceToFaceInterview;
	private String faceToFaceInterviewStatus;
	private String feedback;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "date_recieved", nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	public Date getDateRecieved() {
		return dateRecieved;
	}
	public void setDateRecieved(Date dateRecieved) {
		this.dateRecieved = dateRecieved;
	}
	
	@Column(name = "vendor_company", nullable = false)
	public String getVendorCompany() {
		return vendorCompany;
	}
	public void setVendorCompany(String vendorCompany) {
		this.vendorCompany = vendorCompany;
	}
	
	@Column(name = "vendor_rep_name", nullable = false)
	public String getVendorRepName() {
		return vendorRepName;
	}
	public void setVendorRepName(String vendorRepName) {
		this.vendorRepName = vendorRepName;
	}
	
	@Column(name = "vendor_rep_email", nullable = false)
	public String getVendorRepEmail() {
		return vendorRepEmail;
	}
	public void setVendorRepEmail(String vendorRepEmail) {
		this.vendorRepEmail = vendorRepEmail;
	}
	
	@Column(name = "candidate_name", nullable = false)
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	
	@Column(name = "yrs_of_exp", nullable = false)
	public int getYrsOfExp() {
		return yrsOfExp;
	}
	public void setYrsOfExp(int yrsOfExp) {
		this.yrsOfExp = yrsOfExp;
	}
	
	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "decision")
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	@Column(name = "date_reviewed")
	public Date getDateReviewed() {
		return dateReviewed;
	}
	public void setDateReviewed(Date dateReviewed) {
		this.dateReviewed = dateReviewed;
	}
	public Date getDateTechPhoneInterview() {
		return dateTechPhoneInterview;
	}
	public void setDateTechPhoneInterview(Date dateTechPhoneInterview) {
		this.dateTechPhoneInterview = dateTechPhoneInterview;
	}
	public String getTechPhoneinterviewStatus() {
		return techPhoneinterviewStatus;
	}
	public void setTechPhoneinterviewStatus(String techPhoneinterviewStatus) {
		this.techPhoneinterviewStatus = techPhoneinterviewStatus;
	}
	public Date getDateFaceToFaceInterview() {
		return dateFaceToFaceInterview;
	}
	public void setDateFaceToFaceInterview(Date dateFaceToFaceInterview) {
		this.dateFaceToFaceInterview = dateFaceToFaceInterview;
	}
	public String getFaceToFaceInterviewStatus() {
		return faceToFaceInterviewStatus;
	}
	public void setFaceToFaceInterviewStatus(String faceToFaceInterviewStatus) {
		this.faceToFaceInterviewStatus = faceToFaceInterviewStatus;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
		
}
