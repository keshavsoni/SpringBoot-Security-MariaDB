package com.keshav.hl.springsecurity.model;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	private UUID userId;
	private String firstName;
	private String lastName;
	private String username;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	private int date;
	private int month;
	private int year;
	private String gender;
	private Set<String> roleName;
	private Set<AddressDTO> address;
	private String roles;
	
	

	

}
