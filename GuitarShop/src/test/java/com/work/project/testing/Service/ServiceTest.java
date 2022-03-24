package com.work.project.testing.Service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.work.project.model.GuitarModels;

import com.work.project.repo.Repo;
import com.work.project.service.Services;

@SpringBootTest
public class ServiceTest {

	@MockBean
	private Repo repo;
	
	@Autowired
	private Services service;
	
	GuitarModels testOrder1 = new GuitarModels(6, 1964, 2300.00f, "LP", "mahogany", "humB", "HH", true, true);
	GuitarModels testOrder2 = new GuitarModels(6, 1999, 2300.00f, "LP", "mahogany", "humbucker", "HH", true, true);
	GuitarModels testOrder1ID = new GuitarModels(1l, 6, 1980, 1400.00f, "tele", "maple", "lisptick", "SH", false, false);
	GuitarModels testOrder2ID = new GuitarModels(2l, 7, 2016, 1000.00f, "Ibanez", "mahogany", "humB", "HSH", true, false);
	
	//Create Order:
	@Test
	public void testCreate() {
		
		Mockito.when(repo.save(testOrder1)).thenReturn(testOrder1ID);
		GuitarModels result = service.orderGuitar(testOrder1);
		System.out.println(result);
		System.out.println(testOrder1ID);
		
		Assertions.assertEquals(testOrder1ID, result);
		
		Mockito.verify(repo, Mockito.times(1)).save(testOrder1);

	}
	
	//Get Orders:
	
	
	//Get by ID:
	@Test
	public void testGetID() {
		Mockito.when(repo.findById(1l)).thenReturn(Optional.of(testOrder1ID));
		
		GuitarModels result = service.getById(1l);
		
		Assertions.assertEquals(testOrder1ID, result);
		
		Mockito.verify(repo, Mockito.never()).count();
	}
	
	
	
	//Change order (replace by id):
	//Search by Strings:
	//Search by Year:
	//Search by Price:
	//Search for Model;
	//Get Body type:
	//Select pickups:
	//Select Pickup Configuration:
	//Query: Good For Metal?:
	//Query: RoseWood?:
	//Cancel Order:
	
	
	
	
	
	
	
	
}
