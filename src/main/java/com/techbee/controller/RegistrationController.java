package com.techbee.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.model.Registration;
import com.techbee.service.RegistrationService;

@RequestMapping(path="/registration")
@RestController
public class RegistrationController {

	private RegistrationService registrationService;
	
	@Autowired
	public void setRegistrationService(RegistrationService registrationService) {
		this.registrationService = registrationService;
	}
	
	@PostMapping(path = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public String registration(@RequestBody Registration registration) throws Exception {
		return registrationService.saveRegistration(registration);
	}
	
	@GetMapping(path="/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Registration> findAllRegistration() throws Exception {
		return registrationService.findAllRegistration();
	}
	
	@PutMapping(path = "/update-phoneNumber")
	public String updatePhoneNumberById(@RequestParam int id, @RequestParam long phoneNumber) throws Exception {
		return registrationService.updatePhoneNumberById(id, phoneNumber);
	}

	@GetMapping(path = "/delete/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteByEmail(@PathVariable String email) throws Exception {
		return registrationService.deleteByEmail(email);
	}
}

