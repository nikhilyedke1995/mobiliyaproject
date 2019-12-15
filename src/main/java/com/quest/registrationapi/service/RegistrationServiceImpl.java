package com.quest.registrationapi.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.registrationapi.dto.RegistrationDetailsDTO;
import com.quest.registrationapi.entity.Candidate;
import com.quest.registrationapi.exception.CandidateNotFoundException;
import com.quest.registrationapi.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	Logger LOGGER = LoggerFactory.getLogger(RegistrationServiceImpl.class);

	@Autowired
	RegistrationRepository registrationRepository;

	@Override
	public long registerUser(RegistrationDetailsDTO registrationDTO) {
		// TODO Auto-generated method stub
		LOGGER.debug("Creating candidate profile");
		Candidate candidate = new Candidate();
		BeanUtils.copyProperties(registrationDTO, candidate);
		return registrationRepository.save(candidate).getId();
	}

	@Override
	public RegistrationDetailsDTO findCandidateById(long id) {
		// TODO Auto-generated method stub
		LOGGER.debug("fetching candidate information by id = {} " , id);
		Optional<Candidate> candidate = registrationRepository.findById(id);
		
		if(!candidate.isPresent())
			throw new CandidateNotFoundException("Candidate not found for id = " + id);
		
		RegistrationDetailsDTO regDto = new RegistrationDetailsDTO();
		BeanUtils.copyProperties(candidate.get(), regDto);
		return regDto;
	}
	
}
