package com.cloth.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloth.Repository.UserRepository;
import com.cloth.model.User;



@Service
public class UserImpl
{
	@Autowired
	private UserRepository user_repo;
	
	public void SaveUser(User user)
	{
		user_repo.save(user);
	}
	
	
	 public User findByEmail(String email) {
	        return user_repo.findByEmail(email);
	    }
	

}
