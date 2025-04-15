package com.api.hospitalmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.api.hospitalmanagement.exception.InvalidIDException;
import com.api.hospitalmanagement.model.MedicalHistory;
import com.api.hospitalmanagement.model.Patient;
import com.api.hospitalmanagement.repository.MedicalHistoryRepository;
import com.api.hospitalmanagement.repository.PatientRepository;

@Service
public class PatientService {
	
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;
	
	public Patient add(Patient patient) throws InvalidIDException {
		MedicalHistory history = medicalHistoryRepository.save(patient.getMedicalHistory());
		patient.setMedicalHistory(history);
		Patient user = patientRepository.findByUser(patient.getUser());
		if(user != null)
			throw new InvalidIDException("user exist");
		return patientRepository.save(patient);
	}
}
