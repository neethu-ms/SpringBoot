package com.simpleinterest.service;

import com.simpleinterest.entity.Interest;

public interface InterestService {
	Double calculateInterest(Interest interest);
	void insertInterest(Interest interest);
	Double getMaxPrincipal();

}
