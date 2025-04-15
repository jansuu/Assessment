package com.evaluation.assessment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.model.MedicalHistory;
import com.evaluation.assessment.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService 
{
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;

	public MedicalHistory getById(int medicalHistoryID) throws InvalidIDException 
	{
		// TODO Auto-generated method stub
		Optional<MedicalHistory> optional = medicalHistoryRepository.findById(medicalHistoryID);
		if(optional.isEmpty())
			throw new InvalidIDException("medicalHistory ID is invalid");
		return optional.get();
	}

}
