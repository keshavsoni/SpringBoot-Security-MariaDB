package com.keshav.hl.springsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.keshav.hl.springsecurity.config.exception.RecordNotFoundException;
import com.keshav.hl.springsecurity.model.UserDTO;
import com.keshav.hl.springsecurity.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(value = "UserController", description = "REST Apis related to User!!!!")
@RequestMapping(value="/USERS")
public class UserController {

	@Autowired
	private UserService userService;

	@ApiOperation(value = "Create User")
	@PostMapping(value = "/createUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		UserDTO userDetails = null;

		try {

			if (!ObjectUtils.isEmpty(userDTO)) {
				userDetails = userService.createUser(userDTO);
				return new ResponseEntity<UserDTO>(userDetails, HttpStatus.CREATED);
			} 
		} catch (Exception e) {
			e.getMessage();
		}

		return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "get All Users")
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<UserDTO>> getAllUser() {
		List<UserDTO> listOfUsers = userService.getAllUsers();
		if (!ObjectUtils.isEmpty(listOfUsers)) {
			return new ResponseEntity<List<UserDTO>>(listOfUsers, HttpStatus.OK);
		}
		return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_GATEWAY);
	}
	
	@ApiOperation(value = "get User Details")
	@GetMapping(value = "/getUser")
	public ResponseEntity<List<UserDTO>> getUserByUserName(@RequestParam(value="username",required=false)String userName) {
		List<UserDTO> listOfUsers = userService.getUserByUserName(userName);
		if (!ObjectUtils.isEmpty(listOfUsers)) {
			return new ResponseEntity<List<UserDTO>>(listOfUsers, HttpStatus.OK);
		}else {
			throw new RecordNotFoundException("No User found with such name");
		}
	}

	@GetMapping(value = "/hello")
	public String getHello() {
		return "hey hello";
	}

}
