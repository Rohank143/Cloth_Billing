package com.cloth.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cloth.Repository.TailorRepo;
import com.cloth.model.*;

@Service
public class Tailor_Service_impl 
{
	@Autowired
	private TailorRepo repo;
	

	public Tailor Save_Tailor(Tailor tailor) {
		
			return repo.save(tailor);
		
	}

	public List<Tailor> getAllTailor() {
	
		List<Tailor> list = repo.findAll();
		return list;
	}
	
	 public Tailor getTailorById(Long id) {
	        Optional<Tailor> optionalTailor = repo.findById(id);
	        return optionalTailor.orElse(null); // Return null if customer with given id is not found
	    }
	
	
	  public void deleteTailor(Long id) {
		  repo.deleteById(id);
	    }
	  
	  
	  public void updateTailor(Tailor updatedTailor) {
	        Optional<Tailor> existingTailorOptional = repo.findById(updatedTailor.getTailor_id());

	        if (existingTailorOptional.isPresent()) {
	            Tailor existingTailor = existingTailorOptional.get();
	            // Update fields that you want to allow modification
	            existingTailor.setTailor_name(updatedTailor.getTailor_name());
	            existingTailor.setShop_name(updatedTailor.getShop_name());
	            existingTailor.setShop_address(updatedTailor.getShop_address());
	            existingTailor.setMobile_no(updatedTailor.getMobile_no());
	            existingTailor.setType(updatedTailor.getType());
	            existingTailor.setDate(updatedTailor.getDate());

	            // Save the updated tailor
	            repo.save(existingTailor);
	        } else {
	            throw new RuntimeException("Tailor not found with id: " + updatedTailor.getTailor_id());
	        }

	
	
	}

	public Tailor findById(Long id) {
		 Optional<Tailor> optionalTailor = repo.findById(id);
	        return optionalTailor.orElse(null);
		
	}}
	


