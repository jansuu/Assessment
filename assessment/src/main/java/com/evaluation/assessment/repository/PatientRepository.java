package com.evaluation.assessment.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.assessment.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer>  
{

	Optional<Patient> findByName(String patientName);

}
