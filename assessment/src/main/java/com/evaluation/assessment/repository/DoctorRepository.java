package com.evaluation.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.assessment.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

}
