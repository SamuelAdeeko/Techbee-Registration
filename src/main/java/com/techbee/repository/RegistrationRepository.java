package com.techbee.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techbee.model.Registration;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

//	public String saveRegistration(Registration registration) ;
//	public List<Registration> findAllRegistration();
	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber);
	public String deleteByEmail(String email) ;
	public Registration findRegistrationById(Integer id);

}
