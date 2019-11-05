package com.keshav.hl.springsecurity.service;

import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.keshav.hl.springsecurity.model.UserDTO;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO user = findUserbyUername(username);

	    UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	      builder.roles(user.getRoles());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
		
	}
	
	 private UserDTO findUserbyUername(String username) {
		    if(username.equalsIgnoreCase("admin")) {
		      return new UserDTO();
		    }
		    return null;
		  }

}
