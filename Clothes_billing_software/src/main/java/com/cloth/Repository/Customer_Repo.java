package com.cloth.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloth.model.Customer;

public interface Customer_Repo extends JpaRepository<Customer,Long> 
{

	// boolean existsByCustomerMobileNo(Long customerMobileNo); 
	Customer findByMobileNumber(String mobileNumber);
	
	List<Customer> findByActiveTypeIgnoreCase(String activeType);

}
