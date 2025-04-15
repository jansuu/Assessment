package com.evaluation.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.assessment.model.Patient;
import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.model.MedicalHistory;
import com.evaluation.assessment.model.User;
import com.evaluation.assessment.service.MedicalHistoryService;
import com.evaluation.assessment.service.PatientService;
import com.evaluation.assessment.service.UserService;

@RestController
@RequestMapping("/api/patient")
public class PatientController 
{
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	@PostMapping("/post/{userName}/{medicalHistoryID}")
	public Patient postPatient(@PathVariable String userName, @PathVariable int medicalHistoryID, @RequestBody Patient patient ) throws InvalidIDException
	{
		User user = userService.getByUsername(userName);
		MedicalHistory  medicalHistory = medicalHistoryService.getById(medicalHistoryID);
		
		patient.setMedicalHistory(medicalHistory);
		patient.setUser(user);
		
		patient = patientService.postPatient(patient);
		return patient;
		
	}

}
