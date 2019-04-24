package com.simpleinterest.web.controller;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;


import com.simpleinterest.entity.Interest;
import com.simpleinterest.repository.InterestRepository;
import com.simpleinterest.service.InterestService;

@RestController
public class InterestController {


@Autowired	
InterestRepository repo;
	
	

	@PostMapping("/calculate")
	public String calcualteInterest1(Interest interest){
		
		
		float principal=interest.getPrincipal();
		float rate=interest.getRate();
		float years = interest.getYears();
		
		InterestService interestService = new InterestService(repo);
		float interestAmt= interestService.calculateInterest(principal, rate, years);

		interestService.insertInterest(principal,rate,years,interestAmt);
		
		return ""+interestAmt;
	}
	
	
	
}
