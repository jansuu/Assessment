package com.evaluation.assessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.model.Doctor;
import com.evaluation.assessment.repository.DoctorRepository;

@Service
public class DoctorService 
{
	@Autowired
	private DoctorRepository doctorRepository;

	public Doctor getById(int doctorID) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<Doctor> optional = doctorRepository.findById(doctorID);
		if(optional.isEmpty())
			throw new InvalidIDException("doctor ID is invalid");
		return optional.get();
	}

}
