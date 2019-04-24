package com.simpleinterest.service;


import com.simpleinterest.entity.Interest;
import com.simpleinterest.repository.InterestRepository;




public class InterestService  {
	
	private static Integer count=0;
	
    
	InterestRepository repo;
    
	
	public InterestService(InterestRepository repo){
		this.repo=repo;
	}
    
	
	public float calculateInterest(float principal,float rate,float years ) {
		float interest = principal*(rate/100)*years;
		return interest;
	}
	
	
	public void insertInterest(float principal,float rate,float years,float interestAmt) {
		
		count++;
		Interest interest = new Interest(principal,rate,years,interestAmt);
		System.out.println(repo);
	
		repo.save(interest);
		System.out.println("Inserted Interest");
	}

}
