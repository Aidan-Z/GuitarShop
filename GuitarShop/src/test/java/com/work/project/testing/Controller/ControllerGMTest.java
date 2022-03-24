package com.work.project.testing.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
@Sql(scripts = {"classpath:GuitarShopdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev")
public class ControllerGMTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	GuitarModels testOrder1 = new GuitarModels(6, 1964, 2300.00f, "LP", "mahogany", "humB", "HH", true, true);
	GuitarModels testOrderID = new GuitarModels(1l, 6, 1998, 770.00f, "tele", "maple", "singlecoil", "SH", false, true);
	GuitarModels testOrderID2 = new GuitarModels(2l, 7, 2012, 900.00f, "superstrat", "mahogany", "humbucker", "HH", true, false);
	
	//Create Order:
	@Test
	public void testCreate() throws Exception {
		
		String orderJson = mapper.writeValueAsString(testOrder1);
		
		RequestBuilder req = post("/order").contentType(MediaType.APPLICATION_JSON).content(orderJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = (ResultMatcher) content().string("Order placed: 3");
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody); 
	}
	
	//Get Orders:
	@Test
	public void testGetOrders() throws Exception {
		
		List<GuitarModels> allModels = List.of(testOrderID, testOrderID2);
		
		String allModelsJson = mapper.writeValueAsString(allModels);
		
		RequestBuilder req = get("/getOrders");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(allModelsJson); 
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	//Get by ID:
	@Test
	public void testGetId() throws Exception {
		
		String testGetIdJson = mapper.writeValueAsString(testOrderID);
		
		RequestBuilder req = get("/getId/1");
				
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testGetIdJson);
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	//Change order (replace by id):
	@Test
	public void testUpdateId() throws Exception {
		
		GuitarModels updateOrder = new GuitarModels(6, 1990, 5400.00f, "LP", "mahogany", "humB", "HH", true, true);
		
		String updateOrderJson = mapper.writeValueAsString(updateOrder);
		
		RequestBuilder req = put("/update/2").contentType(MediaType.APPLICATION_JSON).content(updateOrderJson);
		
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().string("Change order: 2");
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	//Search by Strings:
	@Test
	public void testGetStrings() throws Exception {
		
		List<GuitarModels> getStrings = List.of(testOrderID);
		String allStringsJson = mapper.writeValueAsString(getStrings);
		
		RequestBuilder req = get("/getStrings/6");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(allStringsJson);
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	//Search by Year:
	@Test
	public void testGetYear() throws Exception {
		
		String testGetYearJson = mapper.writeValueAsString(testOrderID);
		
		RequestBuilder req = get("/getYear/1998");
				
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testGetYearJson);
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);	
	}
	
	
	//Search by Price:
	@Test
	public void testGetPrice() throws Exception {
		
		String testGetPriceJson = mapper.writeValueAsString(testOrderID);
		
		RequestBuilder req = get("/getPrice/700.00");
				
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testGetPriceJson);
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);	
	}
	
	
	//Search for Model:
	@Test
	public void testModel() throws Exception {
		
		List<GuitarModels> allModels = List.of(testOrderID, testOrderID2);
		
		String allModelsJson = mapper.writeValueAsString(allModels);
		
		RequestBuilder req = get("/getModel");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(allModelsJson);
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	//Select Body type:
	@Test
	public void testBody() throws Exception {
		
		List<GuitarModels> testBody = List.of(testOrderID, testOrderID2); 
		
		String testBodyJson = mapper.writeValueAsString(testBody);
		
		RequestBuilder req = get("/selectBody/maple");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testBodyJson); 
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);	
	}
		
	
	//Select pickups:
	@Test
	public void testPickups() throws Exception {
		
		List<GuitarModels> testPickups = List.of(testOrderID, testOrderID2); 
		
		String testPickupsJson = mapper.writeValueAsString(testPickups);
		
		RequestBuilder req = get("/selectPickups/humbucker");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testPickupsJson); 
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	
	//Select Pickup Configuration:
	@Test
	public void testPickupConfig() throws Exception {
		
		List<GuitarModels> testPickupConfig = List.of(testOrderID, testOrderID2); 
		
		String testPickupConfigJson = mapper.writeValueAsString(testPickupConfig);
		
		RequestBuilder req = get("/pickupConfig/HH");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().json(testPickupConfigJson); 
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	
	//Query: Good For Metal?:
	
	
	
	
	//Query: RoseWood?:
	
	
	//Cancel Order
	@Test
	public void testDeleteId() throws Exception {
		
		RequestBuilder req = delete("/cancelOrder/2");
		
		ResultMatcher checkStatus = status().isAccepted();
		ResultMatcher checkBody = content().string("Order: " + 2 + " canceled");
		
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
		
	}
	
	
	

}
