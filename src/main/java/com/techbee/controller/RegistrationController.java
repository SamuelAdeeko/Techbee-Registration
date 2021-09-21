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
import com.techbee.service.RegisterService;

@RequestMapping(path="/registration")
@RestController
public class RegistrationController {

	private RegisterService registerService;
	
	@Autowired
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	
	@PostMapping(path = "/new", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Registration registration(@RequestBody Registration registration) throws Exception {
		return registerService.saveRegistration(registration);
	}
	
	@GetMapping(path="/all", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Registration> findAllRegistration() throws Exception {
		return registerService.findAllRegistration();
	}
	
	@PutMapping(path = "/update-phoneNumber")
	public Registration updatePhoneNumberById(@RequestParam int id, @RequestParam long phoneNumber) throws Exception {
		return registerService.updatePhoneNumberById(id, phoneNumber);
	}

	@GetMapping(path = "/delete/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public String deleteByEmail(@PathVariable String email) throws Exception {
		return registerService.deleteByEmail(email);
	}
	
	@PostMapping(path = "/remove")
	public void deleteById(@RequestParam Integer id) {
		this.registerService.deleteById(id);
	}
}

