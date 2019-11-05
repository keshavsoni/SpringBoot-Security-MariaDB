package com.keshav.hl.springsecurity.model;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

	private UUID addressID;
	private String area;	
	private String street;	
	private String landmark;	
	private String city;	
	private String state;
	private String country;
	private int zipCode;
}
