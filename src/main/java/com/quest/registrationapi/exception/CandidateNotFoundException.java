package com.quest.registrationapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// This is a custom exception class
@ResponseStatus(HttpStatus.NOT_FOUND)
public class CandidateNotFoundException extends RuntimeException{

	public CandidateNotFoundException(String exception) {
		super(exception);
	}
}
