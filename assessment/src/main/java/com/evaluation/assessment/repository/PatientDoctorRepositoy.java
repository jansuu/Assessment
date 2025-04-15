package com.evaluation.assessment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.assessment.model.PatientDoctor;

public interface PatientDoctorRepositoy extends JpaRepository<PatientDoctor, Integer> 
{

	List<PatientDoctor> findByDoctorId(int doctorID);

}
