package com.work.project.testing.Controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.work.project.model.GuitarModels;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) 
@AutoConfigureMockMvc 
@TestInstance(TestInstance.Lifecycle.PER_CLASS) 
@Sql(scripts = {"claspath:test-data.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev")
public class ControllerGMTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	GuitarModels testOrder1 = new GuitarModels(6, 1964, 2300.00f, "LP", "mahogany", "humB", "HH", true, true);
	GuitarModels testOrderID = new GuitarModels(1l, 6, 1980, 1400.00f, "Tele", "maple", "lisptick", "SH", false, false);
	GuitarModels testOrderID2 = new GuitarModels(2l, 7, 2016, 1000.00f, "Ibanez", "mahogany", "humB", "HSH", true, false);
	
	
	//Create Order:
	@Test
	public void testCreate() throws Exception {
		
		String orderJson = mapper.writeValueAsString(testOrder1);
		
		RequestBuilder req = post("/order").contentType(MediaType.APPLICATION_JSON).content(orderJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = (ResultMatcher) content().string("Order placed: 0");
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	
	}
	
	@Test
	public void testGetOrders() throws Exception {
		
		List<GuitarModels> allModels = List.of(testOrderID, testOrderID2);
		
		String allModelsJson = mapper.writeValueAsString(allModels);
		
		RequestBuilder req = get("/getOrders");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(allModelsJson); 
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	

}
