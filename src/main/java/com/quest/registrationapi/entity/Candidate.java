package com.quest.registrationapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="CANDIDATE")
public class Candidate {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name="NAME")
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Column(name="QUALIFICATION")
	@NotBlank(message = "Qualification is mandatory")
	private String qualification;
	
	@Column(name="EXPERIENCE")
	@NotNull(message = "experience is mandatory")
	private int experience;
	
	@Column(name="CREATED_ON")
	@NotNull(message = "registration date is mandatory")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdOn;
	
	@Column(name="SKILLS")
	@NotBlank(message = "skills are mandatory")
	private String skills;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="CANDIDATE_EXAM", joinColumns={@JoinColumn(name="CANDIDATE_ID", referencedColumnName="ID")}
	    , inverseJoinColumns={@JoinColumn(name="EXAM_ID", referencedColumnName="ID")})
	private List<Exam> exams;

	public Candidate() {
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
		return "Candidate [id=" + id + ", name=" + name + ", qualification=" + qualification + ", experience="
				+ experience + ", createdOn=" + createdOn + ", skills=" + skills + ", exams=" + exams + "]";
	}

	
	
}
