package com.simpleinterest.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.simpleinterest.entity.Interest;
import com.simpleinterest.service.InterestService;
import com.simpleinterest.web.controller.InterestController;

@RunWith(SpringRunner.class)
@WebMvcTest(InterestController.class)
public class InterestControllerTest {
	Interest interest;
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private InterestService interestService;

	@InjectMocks
	private InterestController interestController;

	@Before
	public void setUp() {
		interest = new Interest(1000.0, 10.0, 2.0, 0.0);
        when(interestService.calculateInterest(interest)).thenReturn(200.0);
		doNothing().when(interestService).insertInterest(interest);
		when(interestService.getMaxPrincipal()).thenReturn(1000.0);
	}

	@Test public void testGetInterestAmountWithGoodParams() throws Exception {

		mockMvc.perform(get("/interest/calculate?principal=1000&rate=10&years=2")).
		andExpect(status().isOk()) .andReturn(); 
	}

	@Test public void testGetInterestAmountBadParameters() throws Exception {

		mockMvc.perform(get("/interest/calculate?principal=1000&rate=10&years=-2")).
		andExpect(status().isBadRequest()).andReturn(); 
	}

	

	@Test public void testSettInterestAmountWithGoodParams() throws Exception{


		mockMvc.perform( MockMvcRequestBuilders .post("/interest/calculate")
				.param("principal","1000").param("rate", "10").param("years", "10")
				.contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()) .andReturn();

	}


	@Test public void testSettInterestAmountWithBadParams() throws Exception{

		mockMvc.perform( MockMvcRequestBuilders
				.post("/interest/calculate")
				.param("rate", "10").param("years", "10")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isBadRequest())
		.andReturn();

	}
	
	
	
	@Test public void testGetMaxPrincipal() throws Exception {
        
		mockMvc.perform(get("/interest/maxPrincipal")).
		andExpect(status().isOk()).andReturn(); 
	}

}




