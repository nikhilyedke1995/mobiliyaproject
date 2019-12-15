package com.quest.registrationapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quest.registrationapi.entity.Candidate;


public interface RegistrationRepository extends JpaRepository<Candidate,Long>{
	
}
