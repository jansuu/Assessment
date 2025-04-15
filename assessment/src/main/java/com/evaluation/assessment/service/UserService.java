package com.evaluation.assessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.exception.InvalidNameException;
import com.evaluation.assessment.model.User;
import com.evaluation.assessment.repository.UserRepository;

@Service
public class UserService 
{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	public User signUp(User user) throws InvalidNameException 
	{
		// TODO Auto-generated method stub
		User user1 = userRepository.findByUsername(user.getUsername());
		if(user1 != null)
		{
			throw new InvalidNameException(" account already existing");
		}
		
		if(user.getRole() == null)
		{
			user.setRole("USER_DEFAULT");
		}
			
		String encodedPass = bcrypt.encode(user.getPassword());
		
		user.setPassword(encodedPass);
		
		return userRepository.save(user);
	}

	public User getByUsername(String userName) 
	{
		// TODO Auto-generated method stub
		return userRepository.findByUsername(userName);

	}

}
