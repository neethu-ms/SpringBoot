package com.simpleinterest.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.simpleinterest.entity.Interest;
import com.simpleinterest.repository.InterestRepository;



@RunWith(SpringRunner.class)
public class InterestServiceTest {
	
	
	
	@MockBean
	InterestRepository mockRepo;
	

	
	@InjectMocks
	InterestService service = new InterestServiceImpl();
	
	Interest interest;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		interest = new Interest(1000.0,10.0,2.0,0.0);
		when(mockRepo.save(interest)).thenReturn(interest);
		
		when(mockRepo.getMaxPrincipal()).thenReturn(1000.0);
	}
	
	
	
	  @Test public void testCalculateInterest() {
	  
	  assertEquals((Double)200.0,service.calculateInterest(interest)); 
	  }
	  
	  @Test public void testInsertInterest() {
	  
	  service.insertInterest(interest); 
	  verify(mockRepo,times(1)).save(interest);
	  
	  
	  }
	 
	
	@Test
	public void testGetMaxPrincipal() {
	Double result=service.getMaxPrincipal();	
	assertEquals((Double)1000.0,result);
	}

	
}
