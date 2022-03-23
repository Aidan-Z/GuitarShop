package com.work.project.testing.Service;

import org.junit.jupiter.api.Test;
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
	GuitarModels testOrderID = new GuitarModels(1l, 6, 1980, 1400.00f, "Tele", "maple", "lisptick", "SH", false, false);
	GuitarModels testOrderID2 = new GuitarModels(2l, 7, 2016, 1000.00f, "Ibanez", "mahogany", "humB", "HSH", true, false);
	
	@Test
	public void testCreate() {
		
		
	}
	
}
