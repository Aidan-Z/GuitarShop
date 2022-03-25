package com.work.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.work.project.model.GuitarModels;

public interface Repo extends JpaRepository <GuitarModels, Long> {

	
	List<GuitarModels> findByStrings(int strings);

	List<GuitarModels> findByYear(int year);

	List<GuitarModels> findByPrice(float price);

	List<GuitarModels> findByModel(String model);

	List<GuitarModels> findByBody(String body); // double check if connected

	List<GuitarModels> findByPickups(String pickups);

	List<GuitarModels> findBypickupConfig(String pickupConfig);

	List<GuitarModels> findBygoodForMetal(boolean bool);

	List<GuitarModels> findByroseWood(boolean bool);

	
	
	

}
