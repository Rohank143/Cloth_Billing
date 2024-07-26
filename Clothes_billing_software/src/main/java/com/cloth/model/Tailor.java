package com.cloth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "tailor")
public class Tailor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Tailor_id;

	private String Tailor_name;

	private String Shop_name;
	
	private String Tailor_State;
	
	private String Tailor_City;

	private String Shop_address;

	private String Mobile_no;

	private String Type;

	private Date Date;

	public Tailor() {
		super();
	}

	public Long getTailor_id() {
		return Tailor_id;
	}

	public Tailor(Long tailor_id, String tailor_name, String shop_name,String tailor_state,String tailor_city, String shop_address, String mobile_no,
			String type, Date date) {
		super();
		Tailor_id = tailor_id;
		Tailor_name = tailor_name;
		Shop_name = shop_name;
		Tailor_State=tailor_state;
		Tailor_City=tailor_city;
		Shop_address = shop_address;
		Mobile_no = mobile_no;
		Type = type;
		Date = date;
	}
	
	

	public String getTailor_City() {
		return Tailor_City;
	}

	public void setTailor_City(String tailor_city) {
		Tailor_City = tailor_city;
	}

	public String getTailor_State() {
		return Tailor_State;
	}

	public void setTailor_State(String tailor_state) {
		Tailor_State = tailor_state;
	}

	public void setTailor_id(Long tailor_id) {
		Tailor_id = tailor_id;
	}

	public String getTailor_name() {
		return Tailor_name;
	}

	public void setTailor_name(String tailor_name) {
		Tailor_name = tailor_name;
	}

	public String getShop_name() {
		return Shop_name;
	}

	public void setShop_name(String shop_name) {
		Shop_name = shop_name;
	}

	public String getShop_address() {
		return Shop_address;
	}

	public void setShop_address(String shop_address) {
		Shop_address = shop_address;
	}

	public String getMobile_no() {
		return Mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		Mobile_no = mobile_no;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

}
