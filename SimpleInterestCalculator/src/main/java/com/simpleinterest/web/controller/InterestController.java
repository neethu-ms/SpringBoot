package com.simpleinterest.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simpleinterest.entity.Interest;
import com.simpleinterest.service.InterestService;


@RestController
@RequestMapping("/interest")
public class InterestController {

@Autowired
InterestService interestService;
	
	
	
	@PostMapping("/calculate")
	public ResponseEntity<String> setInterestAmount(Interest interest){
	
		if(!checkPositive(interest.getPrincipal()) || !checkPositive(interest.getRate()) || !checkPositive(interest.getYears()))
	    return new ResponseEntity<String>("Invalid parameters",HttpStatus.BAD_REQUEST);
		Double interestAmt= interestService.calculateInterest(interest);
        interest.setInterestAmt(interestAmt);
		interestService.insertInterest(interest);
		return new ResponseEntity<String>(""+interestAmt, HttpStatus.OK);
	}
	
	private boolean checkPositive(Double num) {
		if(num!=null && num>0)
			return true;
		return false;
	}
	
	@GetMapping("/calculate")
	public ResponseEntity<String> getInterestAmount(@RequestParam("principal") Double principal, @RequestParam("rate") Double rate, @RequestParam("years") Double years ){
		if(!checkPositive(principal) || !checkPositive(rate) || !checkPositive(years))
		    return new ResponseEntity<String>("Invalid parameters",HttpStatus.BAD_REQUEST);
		Interest interest = new Interest(principal,rate,years,0.0);
		Double interestAmt = interestService.calculateInterest(interest);
		return new ResponseEntity<String>(""+interestAmt, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/maxPrincipal")
	public ResponseEntity<String> getMaxPrincipal(){
		
	  Double maxPrincipal = interestService.getMaxPrincipal();
	  return new ResponseEntity<String>(""+maxPrincipal, HttpStatus.OK);
	
	}
	
}
