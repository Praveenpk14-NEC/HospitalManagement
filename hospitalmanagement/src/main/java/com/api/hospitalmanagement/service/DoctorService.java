package com.api.hospitalmanagement.service;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.hospitalmanagement.repository.DoctorRepository;
import com.api.hospitalmanagement.repository.PatientRepository;
import com.api.hospitalmanagement.exception.InvalidIDException;
import com.api.hospitalmanagement.model.Doctor;
import com.api.hospitalmanagement.model.Patient;
import com.api.hospitalmanagement.model.User;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AuthService authService;

	
	public List<Patient> getallDoc(int docId) throws InvalidIDException{
		Optional<Doctor> doc = doctorRepository.findById(docId);
		if(doc.isEmpty())
			throw new InvalidIDException("Invalid Id");
		return patientRepository.findByDoctors(doc.get());
	}


	public Doctor add(int uId, Doctor doc) throws InvalidIDException {
		User user = authService.getById(uId);
		Doctor exDoc = doctorRepository.findByUser(user);
		if(exDoc != null)
			throw new InvalidIDException("doctor exist");
		doc.setUser(user);
		return doctorRepository.save(doc);
	}

}
