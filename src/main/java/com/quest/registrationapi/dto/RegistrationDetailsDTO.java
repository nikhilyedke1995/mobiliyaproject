package com.quest.registrationapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.quest.registrationapi.entity.Exam;

public class RegistrationDetailsDTO implements Serializable{

	private static final long serialVersionUID = 3314616237572991839L;
	
	private long id;
	
	private String name;
	
	private String qualification;
	
	private int experience;
	
	private Date createdOn;
	
	private String skills;
	
	private List<Exam> exams;

	public RegistrationDetailsDTO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public List<Exam> getExams() {
		return exams;
	}

	public void setExams(List<Exam> exams) {
		this.exams = exams;
	}

	@Override
	public String toString() {
		return "RegistrationDetailsDTO [id=" + id + ", name=" + name + ", qualification=" + qualification
				+ ", experience=" + experience + ", createdOn=" + createdOn + ", skills=" + skills + ", exam=" + exams
				+ "]";
	}

	
	
	

}
