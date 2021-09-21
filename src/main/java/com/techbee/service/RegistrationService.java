//package com.techbee.service;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Service;
//
//import com.techbee.model.Registration;
//import com.techbee.repository.RegistrationRepository;
//import com.techbee.util.DbUtil;
//
//@Service
//public class RegistrationService implements RegistrationRepository{
//
//	
//	@Override
//	public String saveRegistration(Registration registration) throws Exception {
//		
//		int result = 0;
//	
//		try (Connection connection = DbUtil.getConnection()){
//			String sql = "insert into techbee.registration(first_name, last_name, "
//					+ "phone_number, email, state) values (?,?,?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			
//			// create the object to send to db
//			preparedStatement.setString(1, registration.getFirstName());
//			preparedStatement.setString(2, registration.getLastName());
//			preparedStatement.setLong(3, registration.getPhoneNumber());
//			preparedStatement.setString(4, registration.getEmail());
//			preparedStatement.setString(5, registration.getState());
//		
//			
//			result = preparedStatement.executeUpdate();
//			if(result == 1) {
//				return "New user successfully added";
//			}
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new Exception("An error occured during registration");
//		}
//		return "error";
//		
//	}
//
//	@Override
//	public List<Registration> findAllRegistration() throws Exception {
//		
//		List<Registration> allRegistration = new ArrayList<>();
//		
//		
//		try (Connection connection = DbUtil.getConnection()) {
//			String sql = "SELECT * FROM techbee.registration";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			// user next() to get all record if more than one record id found
// 			while(resultSet.next()) {
// 				//create a new object 
// 			Registration registration = new Registration();
//			registration.setFirstName(resultSet.getString("first_name"));
//			registration.setLastName(resultSet.getString("last_name"));
//			registration.setPhoneNumber(resultSet.getLong("phone_number"));
//			registration.setEmail(resultSet.getString("email"));
//			registration.setState(resultSet.getString("state"));
//			allRegistration.add(registration);
// 			}
// 			if(allRegistration.size() == 0) {
// 				throw new Exception("No record found in the Database. Enter a new record.");
// 			}
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new Exception("Error getting all registration records");
//		} 
//	
//		return allRegistration;
//	}
//
//	@Override
//	public Registration findByEmailAndPhoneNumber(String email, long phoneNumber) {
//
//		try (Connection connection = DbUtil.getConnection()){
//			String sql = "select FROM techbee.registration WHERE email = ? AND phone_number = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return null;
//		
//	}
//
//	@Override
//	public String updatePhoneNumberById(int id, long phoneNumber) throws Exception {
//		int result = 0;
//		
//		try (Connection connection = DbUtil.getConnection()){
//			String sql = "update techbee.registration set phone_number = ? WHERE id = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setLong(1, phoneNumber);
//			preparedStatement.setInt(2, id);
//			result = preparedStatement.executeUpdate();
//			if(result == 1) {
//				return "Your phone number has been updated to: " + phoneNumber;
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new Exception("User not found with Id " + id);
//		}
//		
//		
//		return "Error updating number";
//	}
//
//	
//	@Override
//	public String deleteByEmail(String email) throws Exception  {
//		int result = 0;
//		
//		try(Connection connection = DbUtil.getConnection()) {
//			String sql = "DELETE FROM techbee.registration WHERE email = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setString(1, email);
//			
//			result = preparedStatement.executeUpdate();
//			if(result == 1) {
//				return "Successfully deleted your account";
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			System.out.println(e);
//			throw new Exception("Error deleting record");
//		}
//		return "Error occurred while deleting your account";
//	}
//}
