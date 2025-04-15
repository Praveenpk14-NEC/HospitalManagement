package com.api.hospitalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.hospitalmanagement.exception.InvalidIDException;
import com.api.hospitalmanagement.model.Patient;
import com.api.hospitalmanagement.service.AppointmentService;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {
	
	@Autowired
	private AppointmentService appointmentService;

	@PostMapping("/addpatient/{pId}/{docId}")
	public Patient addPatient(@PathVariable int pId
			, @PathVariable int docId) throws InvalidIDException {
		return appointmentService.add(pId, docId);
	}
	
	
}
