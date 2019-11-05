/**
 * 
 */
package com.keshav.hl.springsecurity.service;

import java.util.List;

import com.keshav.hl.springsecurity.model.UserDTO;

/**
 * @author Keshav Soni
 *
 */
public interface UserService {

	public UserDTO createUser(UserDTO userDTO);
	public List<UserDTO> getAllUsers();
	public List<UserDTO> getUserByUserName(String userName);
}
