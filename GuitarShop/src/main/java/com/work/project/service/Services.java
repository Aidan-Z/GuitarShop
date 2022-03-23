package com.work.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.work.project.model.GuitarModels;
import com.work.project.repo.Repo;

@Service
public class Services {
	
	private Repo repo;

	public Services(Repo repo) {
		super();
		this.repo = repo;
	}

	//Create Order:
	public GuitarModels orderGuitar(GuitarModels guitar) {
		return repo.save(guitar);
		
	}
	
	//Get Orders:
	public List<GuitarModels> getOrders() {
		return repo.findAll();
	}
	
	
	//Get by ID:
	public GuitarModels getById(long id) {
		return repo.findById(id).get();
	}

	//Change order (replace by id):
	public boolean update(long id, GuitarModels guitar) {
		
		GuitarModels oldGuitar = getById(id);

		oldGuitar.setStrings(guitar.getStrings());
		oldGuitar.setYear(guitar.getYear());
		oldGuitar.setPrice(guitar.getPrice());
		oldGuitar.setModel(guitar.getModel());
		oldGuitar.setBody(guitar.getBody());
		oldGuitar.setPickups(guitar.getPickups());
		oldGuitar.setPickupConfig(guitar.getPickupConfig());
		oldGuitar.setGoodForMetal(guitar.isGoodForMetal());
		oldGuitar.setRoseWood(guitar.isRoseWood());
		
		repo.save(oldGuitar);
		
		return true;
		
	}

	//Search by Strings:
	public List<GuitarModels> getByStrings(int strings) {
		return repo.findByStrings(strings);
	}

	//Search by Year:
	public List<GuitarModels> getByYear(int year) {
		return repo.findByYear(year);
	}

	//Search by Price:
	public List<GuitarModels> getByPrice(int price) {
		return repo.findByPrice(price);
	}
	
	//Search for Model;
	public List<GuitarModels> getByModel(String model) {
		return repo.findByModel(model);
	}
		
	//Get Body type:
	public List<GuitarModels> getByBody(String body) {
		return repo.findByBody(body);
	}
	
	//Select pickups:
	public List<GuitarModels> getByPickups(String pickups) {
		return repo.findByPickups(pickups);
	}
		
	//Select Pickup Configuration:
	public List<GuitarModels> getBypickupConfig(String pickupConfig) {
		return repo.findBypickupConfig(pickupConfig);
	}
	
	//Query: Good For Metal?:
	public List<GuitarModels> getBygoodForMetal(boolean bool) {
		return repo.findBygoodForMetal(bool);
	}
		
	//Query: RoseWood?:
	public List<GuitarModels> getByroseWood(boolean bool) {
		return repo.findByroseWood(bool);
	}

	//Cancel Order:
	public boolean remove(long id) {
		repo.deleteById(id);
		return true;
	}

	

	

	

	

	

	

	

	
	
	

}
