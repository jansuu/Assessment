package com.evaluation.assessment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MedicalHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(nullable = false, length = 255)
	private String illness;
	
	private int numOfYears;
	
	@Column(nullable = false, length = 1000)
	private String currentMedication;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

	public int getNumOfYears() {
		return numOfYears;
	}

	public void setNumOfYears(int numOfYears) {
		this.numOfYears = numOfYears;
	}

	public String getCurrentMedication() {
		return currentMedication;
	}

	public void setCurrentMedication(String currentMedication) {
		this.currentMedication = currentMedication;
	}

	public MedicalHistory(int id, String illness, int numOfYears, String currentMedication) {
		super();
		this.id = id;
		this.illness = illness;
		this.numOfYears = numOfYears;
		this.currentMedication = currentMedication;
	}

	public MedicalHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
