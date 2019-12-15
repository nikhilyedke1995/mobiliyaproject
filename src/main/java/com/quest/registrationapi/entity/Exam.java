package com.quest.registrationapi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="EXAM")
public class Exam {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="POSITION")
	@NotBlank(message = "position is mandatory")
	private String position;
	
	@Column(name="EXAM_DATE")
	@NotNull(message = "exam date is mandatory")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date examDate;

	public Exam() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", position=" + position + ", examDate=" + examDate + "]";
	}
	
	
	
	
}
