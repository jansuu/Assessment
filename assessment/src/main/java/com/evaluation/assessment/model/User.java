package com.evaluation.assessment.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails 
{
	private static final long serialVersionUID = 5121238707792419121L;
	@Id
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	private int id; 
 	
	@Column(nullable = false, length = 255)
 	private String username; 
 	
 	@Column(nullable = false, length = 255)
 	private String password;
 	
 	@Column(nullable = false, length = 255)
 	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	public User(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(role);
		
		Collection<GrantedAuthority> list = new ArrayList<>();
		
		list.add(sga);
		
		return list;
		
	}
	

 	

}
