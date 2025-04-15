package com.api.hospitalmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hospitalmanagement.exception.InvalidIDException;
import com.api.hospitalmanagement.model.Doctor;
import com.api.hospitalmanagement.model.Patient;
import com.api.hospitalmanagement.service.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;

	@GetMapping("/getallDoctor/{doctorId}")
	public List<Patient> getall(@PathVariable int docId) throws InvalidIDException {
		return doctorService.getallDoc(docId);
	}
	
	@PostMapping("/addingDoc/{uId}")
	public Doctor adddoc(@RequestBody Doctor doctor, @PathVariable int uId) throws InvalidIDException {
		return doctorService.add(uId, doctor);
	}
	
}
