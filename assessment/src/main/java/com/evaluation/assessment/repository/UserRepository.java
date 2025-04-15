package com.evaluation.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.assessment.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

}
