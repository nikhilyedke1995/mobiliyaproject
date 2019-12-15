package com.quest.registrationapi.service;

import com.quest.registrationapi.dto.RegistrationDetailsDTO;

public interface RegistrationService {

	/**
	 *  @param RegistrationDetailsDTO 
	 *  @return long
	 *  
	 *  This method accepts a RegistrationDetailsDTO and returns a long id of saved candidate details.
	 * 
	 */
	public long registerUser(RegistrationDetailsDTO registrationDTO);
	
	/**
	 * 
	 * @param id
	 * @return RegistrationDetailsDTO
	 * 
	 * This method accepts a long id and returns candidate details by using RegistrationDetailsDTO from DB
	 */
	public RegistrationDetailsDTO findCandidateById(long id);
	
}
