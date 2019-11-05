package com.keshav.hl.springsecurity.model;

import java.util.Set;

import com.keshav.hl.springsecurity.entity.UserEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDTO {
	
	private long roleid;
	
	private String roleName;
	
	private Set<UserDTO> users;

}
