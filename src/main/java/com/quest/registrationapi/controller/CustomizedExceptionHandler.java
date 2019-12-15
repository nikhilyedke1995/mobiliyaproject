package com.quest.registrationapi.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.quest.registrationapi.exception.CandidateNotFoundException;
import com.quest.registrationapi.exception.ErrorDetails;

/**	This is customized exception handler class. 
 * 	All the exception from this application will land here. 
 */
@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedExceptionHandler.class);

	
	
	
	/**
	 * 
	 * @param CandidateNotFoundException 
	 * @param WebRequest
	 * @return ResponseEntity<ErrorDetails>
	 * 
	 * This method is responsible to handle the CandidateNotFoundException and then configure the exception into ErrorDetails object and then send it back as a response.
	 */
	@ExceptionHandler(CandidateNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleCandidateNotFoundException(CandidateNotFoundException exe,WebRequest request){
		LOGGER.info("CandidateNotFoundException occured " + exe.getMessage());
		ErrorDetails error = new ErrorDetails(new Date(),exe.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	/**
	 * 
	 * @param Exception
	 * @param WebRequest
	 * @return ResponseEntity<ErrorDetails>
	 * 
	 * This method will handle and map all the generic exceptions into ErrorDetails object, and then it will send it back as a response. 
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
	  LOGGER.info("Exception occured " + ex.getMessage());
	  ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),request.getDescription(false));
	  return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	/**
	 * 
	 * @param ConstraintViolationException
	 * @return Map<String,String>
	 * 
	 * 	This method handles all the validation exception in case any validation fails. It then send the validation message back as response.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleValidationExceptions(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getConstraintViolations().forEach(s->{
	    	errors.put(s.getRootBeanClass().getName() + " " + s.getPropertyPath(), s.getMessage());
	    });
	    return errors;
	}
	
	
}
