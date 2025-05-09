package com.evaluation.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.model.User;
import com.evaluation.assessment.repository.UserRepository;


@Service
public class MyUserService implements UserDetailsService  
{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user = userRepository.findByUsername(username);
	    if (user == null) 
	    {
	        throw new UsernameNotFoundException("User not found: " + username);
	    }
	    return user;
	}

}
