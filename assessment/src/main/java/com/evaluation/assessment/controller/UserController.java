package com.evaluation.assessment.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.assessment.config.JwtUtil;
import com.evaluation.assessment.dto.TokenDto;
import com.evaluation.assessment.exception.InvalidNameException;
import com.evaluation.assessment.model.User;
import com.evaluation.assessment.service.MyUserService;
import com.evaluation.assessment.service.UserService;

@RestController
@RequestMapping("/api/User")
public class UserController 
{
	@Autowired
 	private AuthenticationManager authenticationManager;
	
	@Autowired
    private MyUserService myUserService;
	
	@Autowired
 	private UserService userService;
	
	@Autowired
 	private JwtUtil jwtUtil;
 	
 	@PostMapping("/signup")
 	public User signUp(@RequestBody User user) throws InvalidNameException 
 	{
 		return userService.signUp(user);
 	}
 	
 	
 	@PostMapping("/login")
 	public UserDetails login(Principal principal)
 	{
 		String username = principal.getName();
 		return myUserService.loadUserByUsername(username);
 	}

 	@PostMapping("/token/generate")
 	public TokenDto generateToken(@RequestBody User user,TokenDto dto) {
 		Authentication auth = 
 		new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
 	
 		authenticationManager.authenticate(auth);
 		
 		String token =  jwtUtil.generateToken(user.getUsername()); 
 		dto.setToken(token);
 		dto.setUsername(user.getUsername());
 		dto.setExpiry(jwtUtil.extractExpiration(token).toString());
 		return dto; 
 	}
 	
 	@GetMapping("/details")
 	public UserDetails getUserDetails(Principal principal) 
 	{
 		String username = principal.getName();
 		return myUserService.loadUserByUsername(username);
 	}
 	

}
