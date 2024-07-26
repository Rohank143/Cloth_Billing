package com.cloth.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customer")
public class Customer 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Customer_id;
	
	private String Customer_name;
	
	private String Customer_State;
	
	private String Customer_City;
	
	private String Customer_address;
	
	private String mobileNumber;
	
	private String Customer_type;
	
	private String activeType;
	
	private Date Customer_date;

	public Customer(Long customer_id, String customer_name,String customer_state,String customer_city, String customer_address, String customer_mobileNo,
			String customer_type,String activetype, Date customer_date) {
		super();
		Customer_id = customer_id;
		Customer_name = customer_name;
		Customer_State = customer_state;
		Customer_City=customer_city;
		Customer_address = customer_address;
		mobileNumber = customer_mobileNo;
		Customer_type = customer_type;
		activeType=activetype;
		Customer_date = customer_date;
	}
	
	
	

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}




	public String getActiveType() {
		return activeType;
	}




	public void setActiveType(String activetype) {
		activeType = activetype;
	}




	public String getCustomer_State() {
		return Customer_State;
	}




	public void setCustomer_State(String customer_State) {
		Customer_State = customer_State;
	}




	public String getCustomer_City() {
		return Customer_City;
	}




	public void setCustomer_City(String customer_City) {
		Customer_City = customer_City;
	}




	public String getMobileNumber() {
		return mobileNumber;
	}




	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}




	public Long getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		Customer_id = customer_id;
	}

	public String getCustomer_name() {
		return Customer_name;
	}

	public void setCustomer_name(String customer_name) {
		Customer_name = customer_name;
	}

	public String getCustomer_address() {
		return Customer_address;
	}

	public void setCustomer_address(String customer_address) {
		Customer_address = customer_address;
	}

	public String getCustomer_mobileNo() {
		return mobileNumber;
	}

	public void setCustomer_mobileNo(String customer_mobileNo) {
		mobileNumber = customer_mobileNo;
	}

	public String getCustomer_type() {
		return Customer_type;
	}

	public void setCustomer_type(String customer_type) {
		Customer_type = customer_type;
	}

	public Date getCustomer_date() {
		return Customer_date;
	}

	public void setCustomer_date(Date customer_date) {
		Customer_date = customer_date;
	}
	
	
}
