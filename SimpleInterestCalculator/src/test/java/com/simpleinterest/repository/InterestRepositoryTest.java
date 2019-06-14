package com.simpleinterest.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.simpleinterest.SimpleInterestCalculatorApplication;
import com.simpleinterest.entity.Interest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SimpleInterestCalculatorApplication.class)
public class InterestRepositoryTest {
	
	@Autowired
	InterestRepository repo;
	
	@Test
	public void testSave() {
		Interest interest = new Interest(7000.0,10.0,1.0,700.0);
		repo.save(interest);
		Optional<Interest> interestFetch = repo.findById(interest.getId());
		assertEquals(interestFetch.get().getId(),interest.getId());
		
	}

	@Test
	public void testGetMaxPrincipal() {
		Interest interest1 = new Interest(7000.0,10.0,1.0,700.0);
		repo.save(interest1);
		Interest interest2 = new Interest(9000.0,10.0,1.0,700.0);
		repo.save(interest2);
		Interest interest3 = new Interest(4000.0,10.0,1.0,700.0);
		repo.save(interest3);
		Double maxPrincipal = repo.getMaxPrincipal();
		assertEquals((Double)9000.0,maxPrincipal);
		
	}
}
