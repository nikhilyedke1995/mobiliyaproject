package com.quest.registrationapi.service;

import com.quest.registrationapi.dto.RegistrationDetailsDTO;

public interface RegistrationService {

	public long registerUser(RegistrationDetailsDTO registrationDTO);
	
	public RegistrationDetailsDTO findCandidateById(long id);
	
}
