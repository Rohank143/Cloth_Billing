package com.cloth.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cloth.Repository.WorkerRepository;
import com.cloth.model.Worker;



public class WorkerImpl 
{
     @Autowired
	private WorkerRepository worker_repo;
     
     
     public Worker findByEmail(String email) {
         return worker_repo.findByEmail(email);
     }
	
	
}

