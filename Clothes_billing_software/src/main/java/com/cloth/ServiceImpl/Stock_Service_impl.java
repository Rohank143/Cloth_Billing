package com.cloth.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.Repository.Stock_Repo;
import com.cloth.model.Stock_info;

@Service
public class Stock_Service_impl 
{
	@Autowired
	private Stock_Repo repo;
	
	public void Save_Stock(Stock_info stock)
	{
	    repo.save(stock);
	}

	public List<Stock_info> getAllStock() {
	
		List<Stock_info> list = repo.findAll();
		return list;
	}
	

}
