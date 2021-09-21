package com.techbee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.model.Registration;
import com.techbee.repository.RegistrationRepository;

@Service
public class RegisterService {
	
	private RegistrationRepository registrationRepository;
	
	@Autowired
	public void setRegistrationRepository(RegistrationRepository registrationRepository) {
		this.registrationRepository = registrationRepository;
	}

	
	public Registration saveRegistration(Registration registration) {
		return this.registrationRepository.save(registration);
	}
	
	public List<Registration> findAllRegistration() {
		return this.registrationRepository.findAll();
	}
	
	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber) {
		return this.registrationRepository.findByEmailAndPhoneNumber(email, phoneNumber);
	}
	
	public Registration updatePhoneNumberById(Integer id, long phoneNumber) {
		Registration register = this.registrationRepository.findRegistrationById(id);
		String firstName = register.getFirstName();
		String lastName = register.getLastName();
		String email = register.getEmail();
		String state = register.getState();
		Registration updateRegistration = new Registration(id,firstName, lastName, phoneNumber,
				email, state);
		Registration saveRegistration = this.registrationRepository.save(updateRegistration);
		return saveRegistration;
	}
	
	public String deleteByEmail(String email) {
		this.registrationRepository.deleteByEmail(email);
		return "successfully deleted";
	}
	
	public void deleteById(Integer id) {
		this.registrationRepository.deleteById(id);
	}
}
