package com.cloth.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cloth.model.User;



@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);	
}
