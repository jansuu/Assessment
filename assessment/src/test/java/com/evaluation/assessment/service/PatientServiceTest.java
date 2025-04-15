package com.evaluation.assessment.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.evaluation.assessment.enums.Speciality;
import com.evaluation.assessment.exception.InvalidIDException;
import com.evaluation.assessment.model.Doctor;
import com.evaluation.assessment.model.MedicalHistory;
import com.evaluation.assessment.model.Patient;
import com.evaluation.assessment.model.PatientDoctor;
import com.evaluation.assessment.model.User;
import com.evaluation.assessment.repository.PatientDoctorRepositoy;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PatientServiceTest 
{
	@InjectMocks
	private PatientDoctorService patientDoctorService;
	@Mock
	private PatientDoctorRepositoy patientDoctorRepositoy;
	
	PatientDoctor p1;
	PatientDoctor p2;
	PatientDoctor p3;
	
	@BeforeEach
	public void init() 
	{
		p1 = new PatientDoctor(1,new Patient(1,"Patient1", 23,new MedicalHistory(1,"fever",2,"dolo"),new User(1,"Patient1@example.com", "1234","PATIENT")), new Doctor(1, "Dr.jay", Speciality.ORTHO, new User(1, "user1@example.com", "1234", "PATIENT")));
		p2 = new PatientDoctor(2,new Patient(2,"Patient1", 24,new MedicalHistory(2,"fever",3,"dolo"),new User(2,"Patient2@example.com", "1234","DOCTOR")), new Doctor(1, "Dr.josh", Speciality.GYNAC, new User(2, "user2@example.com", "1234", "DOCTOR")));
		p3 = new PatientDoctor(3,new Patient(3,"Patient1", 25,new MedicalHistory(3,"fever",1,"dolo"),new User(3,"Patient3@example.com", "1234","PATIENT")), new Doctor(1, "Dr.hema", Speciality.PHYSICIAN, new User(3, "user3@example.com", "1234", "PATIENT")));
	}
	
	@Test
	public void getPatientByDoctorIdTest() throws InvalidIDException 
	{
		List<PatientDoctor> list = Arrays.asList(p1,p2);
		int Docid = 1;
		when(patientDoctorRepositoy.findByDoctorId(Docid)).thenReturn(list); 
		
		assertEquals(list, patientDoctorService.getPatientByDoctorId(Docid));
		
		Docid = 2;
		assertEquals(list, patientDoctorService.getPatientByDoctorId(Docid));
	 }
	

}
