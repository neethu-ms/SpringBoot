package com.country.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.entity.Country;
import com.country.repository.CountryRepository;

@RestController
public class CountryController {
	@Autowired
	CountryRepository repo;
	
	@RequestMapping("/country")
	public Country getCountryDetails(@RequestParam("name") String name) {
		
       
       name=name.toUpperCase();
		Optional<Country> countryOpt = repo.findById(name);
		
		
	    Country country = countryOpt.orElseThrow(()->new RuntimeException("Country does not exist"));
		
		return country;
	}
	
}
