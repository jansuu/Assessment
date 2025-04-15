package com.evaluation.assessment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluation.assessment.model.Patient;
import com.evaluation.assessment.model.PatientDoctor;
import com.evaluation.assessment.repository.PatientDoctorRepositoy;

@Service
public class PatientDoctorService 
{
	@Autowired
	private PatientDoctorRepositoy patientDoctorRepositoy;

	public List<Patient> getPatientByDoctorId(int doctorID) 
	{
		// TODO Auto-generated method stub
		List<PatientDoctor> list = patientDoctorRepositoy.findByDoctorId(doctorID);
		return list.stream()
				.map(p->p.getPatient())
				.toList();
	}

	public PatientDoctor add(PatientDoctor patientDoctor) 
	{
		// TODO Auto-generated method stub
		return patientDoctorRepositoy.save(patientDoctor);
	}

}
