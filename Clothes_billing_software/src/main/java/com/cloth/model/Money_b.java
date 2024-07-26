package com.cloth.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="money")
public class Money_b {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String borrowedAmount;
	private String paidAmount;
	private String RemainingAmount;
	private String totalAmount;
	private Date date;
	private String reason;
	
	
	
	
	public String getRemainingAmount() {
		return RemainingAmount;
	}
	public void setRemainingAmount(String remainingAmount) {
		RemainingAmount = remainingAmount;
	}
	public Money_b() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBorrowedAmount() {
		return borrowedAmount;
	}
	public void setBorrowedAmount(String borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Money_b(Long id, String name, String address, String borrowedAmount, String paidAmount,String remainingAmount, String totalAmount,
			Date date, String reason) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.borrowedAmount = borrowedAmount;
		this.paidAmount = paidAmount;
		this.RemainingAmount=remainingAmount;
		this.totalAmount = totalAmount;
		this.date = date;
		this.reason = reason;
	}
	
}