package com.keshav.hl.springsecurity.config.exception;

import java.util.List;

import lombok.Data;

@Data
public class ErrorResponse {

	
	private String message;
    private List<String> details;
    
	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}
    
    
	
}
