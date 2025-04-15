package com.evaluation.assessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.exception.InvalidNameException;
import com.evaluation.assessment.model.Patient;
import com.evaluation.assessment.repository.PatientRepository;

@Service
public class PatientService 
{
	@Autowired
	private PatientRepository patientRepository;

	public Patient getByName(String patientName) throws InvalidNameException 
	{
		// TODO Auto-generated method stub
		Optional<Patient> optional = patientRepository.findByName(patientName);
		if(optional.isEmpty())
			throw new InvalidNameException("patient name is invalid");
		return optional.get();
	}

	public Patient postPatient(Patient patient) 
	{
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

}
