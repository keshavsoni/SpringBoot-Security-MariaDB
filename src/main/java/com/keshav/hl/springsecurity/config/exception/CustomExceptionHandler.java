package com.keshav.hl.springsecurity.config.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	private String INCORRECT_REQUEST = "INCORRECT_REQUEST";
	//private String BAD_REQUEST = "BAD_REQUEST";

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<ErrorResponse> recordNotFoundException(RecordNotFoundException recordNotFoundException,
			WebRequest request) {

		List<String> error = new ArrayList<>();
		
		error.add(recordNotFoundException.getLocalizedMessage());

		ErrorResponse errorResponse = new ErrorResponse(INCORRECT_REQUEST, error);

		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

}
