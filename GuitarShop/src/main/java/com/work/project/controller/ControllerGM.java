package com.work.project.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.work.project.model.GuitarModels;
import com.work.project.service.Services;

@RestController
public class ControllerGM {

	private Services service; 
	
	public ControllerGM(Services service) {
		super();
		this.service = service;
	}
	
	
	//Create Order:
	@PostMapping("/order")
	public ResponseEntity<String> orderGuitar(@RequestBody GuitarModels guitar) {
		System.out.println(guitar);
		
		service.orderGuitar(guitar);
		
		ResponseEntity<String> response = new ResponseEntity<String>("Order placed: " + guitar.getId(), HttpStatus.CREATED);
		return response;
	}
	
	//Get Orders:
	@GetMapping("/getOrders")
	public ResponseEntity<List<GuitarModels>> getBookings() {
		
		List<GuitarModels> response = service.getOrders();
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Get by ID:
	@GetMapping("/getId/{id}")
	public ResponseEntity<GuitarModels> getById(@PathVariable("id") long id) {
		
		GuitarModels result = service.getById(id);
		
		ResponseEntity<GuitarModels> response = new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		
		return response;
	}
	

	//Change order (replace by id):
	@PutMapping("/update/{id}")
	public ResponseEntity<String> changeOrder(@PathVariable("id") long id, @RequestBody GuitarModels guitar) {
		
		service.update(id, guitar);
		
		String response = "Change order: " + id;
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	//Search by Strings:
	@GetMapping("/getstrings/{strings}")
	public ResponseEntity<List<GuitarModels>> getByStrings(@PathVariable("strings") int strings) {
		
		List<GuitarModels> response = service.getByStrings(strings);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Search by Year:
	@GetMapping("/getYear/{year}")
	public ResponseEntity<List<GuitarModels>> getByYear(@PathVariable("year") int year) {
		
		List<GuitarModels> response = service.getByYear(year);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Search by Price:
	@GetMapping("/getPrice/{price}")
	public ResponseEntity<List<GuitarModels>> getByPrice(@PathVariable("price") int price) {
		
		List<GuitarModels> response = service.getByPrice(price);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
		
	//Search for Model:
	@GetMapping("/getModel/{model}")
	public ResponseEntity<List<GuitarModels>> getByModel(@PathVariable("model") String model) {
		
		List<GuitarModels> response = service.getByModel(model);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Select Body type:
	@PutMapping("/selectBody/{body}")
	public ResponseEntity<List<GuitarModels>> getByBody(@PathVariable("body") String body) {
		
		List<GuitarModels> response = service.getByBody(body);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Select pickups:
	@PutMapping ("/select/{pickups}")
	public ResponseEntity<List<GuitarModels>> getByPickups(@PathVariable("Pickups") String Pickups) {
		
		List<GuitarModels> response = service.getByPickups(Pickups);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Select Pickup Configuration:
	@PutMapping ("/pickupConfig/{config}")
	public ResponseEntity<List<GuitarModels>> getBypickupConfig(@PathVariable("pickupConfig") String pickupConfig) {
		
		List<GuitarModels> response = service.getBypickupConfig(pickupConfig);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Query: Good For Metal?:
	@GetMapping("/metal/{bool}")
	public ResponseEntity<List<GuitarModels>> getBygoodForMetal(@PathVariable("bool") boolean bool) {
		
		List<GuitarModels> response = service.getBygoodForMetal(bool);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Query: RoseWood?:
	@GetMapping("/roseWood/{bool}")
	public ResponseEntity<List<GuitarModels>> getByroseWood(@PathVariable("bool") boolean bool) {
			
		List<GuitarModels> response = service.getByroseWood(bool);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	//Cancel Order
	@DeleteMapping("/cancelOrder/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
		
		service.remove(id);
		String response = "Order: " + id + " canceled";
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}
	
	
	
}
