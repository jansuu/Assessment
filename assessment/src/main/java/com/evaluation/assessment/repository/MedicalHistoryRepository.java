package com.evaluation.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.assessment.model.MedicalHistory;

public interface MedicalHistoryRepository extends JpaRepository<MedicalHistory, Integer>  {

}
