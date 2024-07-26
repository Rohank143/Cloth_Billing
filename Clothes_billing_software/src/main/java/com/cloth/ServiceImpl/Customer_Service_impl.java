package com.cloth.ServiceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.Repository.Customer_Repo;
import com.cloth.model.Customer;

@Service
public class Customer_Service_impl 
{
	@Autowired
	private Customer_Repo repo;
	

	public Customer Save_Customer(Customer customer) {
		try {
			// Check if mobile number already exists
			Customer existingCustomer = repo.findByMobileNumber(customer.getCustomer_mobileNo());
			if (existingCustomer != null) {
				throw new RuntimeException("Duplicate mobile number");
			}
			return repo.save(customer);
		} catch (Exception e) {
			
			throw new RuntimeException("Duplicate mobile number: " + customer.getCustomer_mobileNo());
		}
		
	}

	public List<Customer> getAllCustomer() {
	
		List<Customer> list = repo.findAll();
		return list;
	}
	

	 public Customer getCustomerById(Long id) {
	        Optional<Customer> optionalCustomer = repo.findById(id);
	        return optionalCustomer.orElse(null); // Return null if customer with given id is not found
	    }

	    public void updateCustomer(Customer updatedCustomer) {
	        Optional<Customer> existingCustomerOptional = repo.findById(updatedCustomer.getCustomer_id());
	        if (existingCustomerOptional.isPresent()) {
	            Customer existingCustomer = existingCustomerOptional.get();
	            // Update fields that you want to allow modification
	            existingCustomer.setCustomer_name(updatedCustomer.getCustomer_name());
	            existingCustomer.setCustomer_address(updatedCustomer.getCustomer_address());
	            existingCustomer.setCustomer_State(updatedCustomer.getCustomer_State());
	            existingCustomer.setCustomer_City(updatedCustomer.getCustomer_City());
	            existingCustomer.setCustomer_mobileNo(updatedCustomer.getCustomer_mobileNo());
	            existingCustomer.setCustomer_type(updatedCustomer.getCustomer_type());
	            existingCustomer.setActiveType(updatedCustomer.getActiveType());
	            existingCustomer.setCustomer_date(updatedCustomer.getCustomer_date());

	            // Save the updated customer
	            repo.save(existingCustomer);
	        } else {
	            throw new RuntimeException("Customer not found with id: " + updatedCustomer.getCustomer_id());
	        }
	    }
	    
	    
	    public void deleteCustomer(Long id) {
	        Optional<Customer> customerOptional = repo.findById(id);
	        if (customerOptional.isPresent()) {
	            repo.deleteById(id);
	        } else {
	            throw new RuntimeException("Customer not found with id: " + id);
	        }
	    }

	    
	    public List<Customer> findActiveCustomers() {
	        return repo.findByActiveTypeIgnoreCase("Active"); // Example method in repository to fetch active customers
	    }

	    public List<Customer> findNonActiveCustomers() {
	        return repo.findByActiveTypeIgnoreCase("Non_Active"); // Example method in repository to fetch non-active customers
	    }
	
//	 public boolean doesCustomerExistByMobileNo(Long mobileNo) {
//	        return repo.existsByCustomerMobileNo(mobileNo);
//	    }
	    
	    
	  
	    public List<Customer> getActiveCustomers() {
	        return repo.findByActiveTypeIgnoreCase("Active");
	    }

	   
	    public List<Customer> getNonActiveCustomers() {
	        return repo.findByActiveTypeIgnoreCase("Non-Active");
	    }
	    

}
