package com.country.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryErrorController implements ErrorController{
	


	@Override
	public String getErrorPath() {
		
		return "/error";
	}
	
	@RequestMapping("/error")
	public String getErrorMessage() {
       
        return "Country does not exist";
    }

}
