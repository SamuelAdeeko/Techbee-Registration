package com.techbee.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.techbee.model.Registration;

@Repository
public interface RegistrationRepository {

	public String saveRegistration(Registration registration) throws Exception;
	public List<Registration> findAllRegistration() throws Exception;
	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber);
	public String updatePhoneNumberById(int id, long phoneNumber) throws Exception;
	public String deleteByEmail(String email) throws Exception;

}
