package com.cloth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="stock")
public class Stock_info 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Product_id;
	
    private String Product_name;
    
	private String Product_distributor;
	
	private String Product_type;
	
	private String Product_description;
	
	private Long Product_quantity;
	
	private Long Product_rate;

	

	

	public Stock_info(Long product_id, String product_name, String product_distributor,
			String product_type, String product_description, Long product_quantity, Long product_rate) {
		super();
		Product_id = product_id;
		Product_name = product_name;
		Product_distributor = product_distributor;
		Product_type = product_type;
		Product_description = product_description;
		Product_quantity = product_quantity;
		Product_rate = product_rate;
	}

	public Stock_info() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getProduct_id() {
		return Product_id;
	}

	public void setProduct_id(Long product_id) {
		Product_id = product_id;
	}

	public String getProduct_name() {
		return Product_name;
	}

	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}

	public String getProduct_distributor() {
		return Product_distributor;
	}

	public void setProduct_distributor(String product_distributor) {
		Product_distributor = product_distributor;
	}

	public String getProduct_type() {
		return Product_type;
	}

	public void setProduct_type(String product_type) {
		Product_type = product_type;
	}

	public String getProduct_description() {
		return Product_description;
	}

	public void setProduct_description(String product_description) {
		Product_description = product_description;
	}

	public Long getProduct_quantity() {
		return Product_quantity;
	}

	public void setProduct_quantity(Long product_quantity) {
		Product_quantity = product_quantity;
	}

	public Long getProduct_rate() {
		return Product_rate;
	}

	public void setProduct_rate(Long product_rate) {
		Product_rate = product_rate;
	}
	
	
	



}
