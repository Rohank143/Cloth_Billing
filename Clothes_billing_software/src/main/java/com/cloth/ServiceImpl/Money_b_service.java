package com.cloth.ServiceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.Repository.Money_Repository;

import com.cloth.model.Money_b;

@Service
public class Money_b_service {
	@Autowired
	private Money_Repository money_repo;
	public void moneySave(com.cloth.model.Money_b money) {
		money_repo.save(money);
	}
	public List<com.cloth.model.Money_b> getAllMoney() {
		
		List<com.cloth.model.Money_b> list = money_repo.findAll();
		return list;
	}
	
	
	public List<Money_b> getAllMoney1() {
		
		List<Money_b> list = money_repo.findAll();
		return list;
	}
	
}