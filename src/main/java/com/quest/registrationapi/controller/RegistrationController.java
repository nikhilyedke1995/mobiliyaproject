package com.quest.registrationapi.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quest.registrationapi.dto.RegistrationDetailsDTO;
import com.quest.registrationapi.service.RegistrationService;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;
	
	Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
	
	@PostMapping
	public ResponseEntity<Long> registerUser(@Valid @RequestBody RegistrationDetailsDTO regDTO) {
		LOGGER.debug("Received request to create candidate {}", regDTO);
		long result = registrationService.registerUser(regDTO);
		return new ResponseEntity<Long>(result,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@Cacheable(value="cacheCandidate")
	public ResponseEntity<RegistrationDetailsDTO> findCandidate(@PathVariable long id){
		LOGGER.debug("Looking for candidate ID = {}",id );
		RegistrationDetailsDTO result = registrationService.findCandidateById(id);
		return new ResponseEntity<>(result,HttpStatus.FOUND);
	}
}
