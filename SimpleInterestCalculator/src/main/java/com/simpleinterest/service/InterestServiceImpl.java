package com.simpleinterest.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simpleinterest.entity.Interest;
import com.simpleinterest.repository.InterestRepository;



@Service
public class InterestServiceImpl implements InterestService {
	

	
    @Autowired
	InterestRepository repo;
    
	
	public Double calculateInterest(Interest interest ) {
		
		Double interestAmt = interest.getPrincipal()*(interest.getRate()/100)*interest.getYears();
		return interestAmt;
	}
	
	
	public void insertInterest(Interest interest) {
		repo.save(interest);
		System.out.println("Inserted Interest");
	}

	public Double getMaxPrincipal(){
		
		Double maxPrincipal = repo.getMaxPrincipal();
		return maxPrincipal;
	}
	
	
	
   
	
}
