package com.evaluation.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.exception.InvalidNameException;
import com.evaluation.assessment.model.Doctor;
import com.evaluation.assessment.model.Patient;
import com.evaluation.assessment.model.PatientDoctor;
import com.evaluation.assessment.service.DoctorService;
import com.evaluation.assessment.service.PatientDoctorService;
import com.evaluation.assessment.service.PatientService;


@RestController
@RequestMapping("/api/patient/doctor")
public class PatientDoctorController 
{
	@Autowired
	private PatientDoctorService patientDoctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	// make appointment
	@PostMapping("/add/{patientName}/{doctorID}")
	public PatientDoctor add(@PathVariable String patientName, 
						   @PathVariable int doctorID,
						   @RequestBody PatientDoctor patientDoctor) throws InvalidIDException, InvalidNameException 
	{
		
		Patient patient =  patientService.getByName(patientName);
		Doctor doctor = doctorService.getById(doctorID);
		
		patientDoctor.setPatient(patient);
		patientDoctor.setDoctor(doctor);
		
		
		patientDoctor = patientDoctorService.add(patientDoctor);
		
		return patientDoctor;
	}
	
	// get patient by doctor ID
	@GetMapping("/get/{doctorID}")
	public List<Patient> getPatientByDoctorId(@PathVariable int doctorID) 
	{
		return patientDoctorService.getPatientByDoctorId(doctorID);
	}

}
