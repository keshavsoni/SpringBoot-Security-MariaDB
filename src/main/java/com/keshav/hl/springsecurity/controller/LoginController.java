package com.keshav.hl.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.hl.springsecurity.model.UserDTO;
import com.keshav.hl.springsecurity.service.SecurityService;

@RestController
public class LoginController {
	
	@Autowired
	private SecurityService securityService;
	
	@PostMapping(value="/")
	public String login(@RequestBody UserDTO userDTO) {
		
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		String msg=null;
		
		/*if(securityService.autoLogin(username, password)) {
			msg="login successfull";
		}*/
		
		return msg;
	}

}
