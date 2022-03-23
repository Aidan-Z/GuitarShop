package com.work.project.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GuitarModels {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 30)
	private int strings;
	
	@Column(nullable = false, length = 30)
	private int year;
	
	@Column(nullable = false, length = 30)
	private float price;
	
	@Column(nullable = false, length = 30)
	private String model;
	
	@Column(nullable = false, length = 30)
	private String body;
	
	@Column(nullable = false, length = 30)
	private String pickups;
	
	@Column(nullable = false, length = 30)
	private String pickupConfig;
	
	@Column(nullable = false)
	private boolean goodForMetal; 
	
	@Column(nullable = false)
	private boolean roseWood;
	
	public GuitarModels() {
		super();
	}

	// Constructor With ID:
	public GuitarModels(long id, int strings, int year, float price, String model, String body, String pickups,
			String pickupConfig, boolean goodForMetal, boolean roseWood) {
		super();
		this.id = id;
		this.strings = strings;
		this.year = year;
		this.price = price;
		this.model = model;
		this.body = body;
		this.pickups = pickups;
		this.pickupConfig = pickupConfig;
		this.goodForMetal = goodForMetal;
		this.roseWood = roseWood;
	}

	// Constructor Without ID:
	public GuitarModels(int strings, int year, float price, String model, String body, String pickups,
			String pickupConfig, boolean goodForMetal, boolean roseWood) {
		super();
		this.strings = strings;
		this.year = year;
		this.price = price;
		this.model = model;
		this.body = body;
		this.pickups = pickups;
		this.pickupConfig = pickupConfig;
		this.goodForMetal = goodForMetal;
		this.roseWood = roseWood;
	}

	// Getters and Setters:
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStrings() {
		return strings;
	}

	public void setStrings(int strings) {
		this.strings = strings;
		if(strings <= 5) {
			System.out.println("This is not a guitar");
			return;
		} else {
			this.strings = strings;
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
		if(year <= 1952) {
			System.out.println("Wow man thats crazy!");
			return;
		} else if(year >= 1953 & year <= 2000) { 
			System.out.println("Dude that awesome");
			return;
		} else {
			System.out.println("Ok but imagine if it was antique");
		}
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getPickups() {
		return pickups;
	}

	public void setPickups(String pickups) {
		this.pickups = pickups;
	}

	public String getPickupConfig() {
		return pickupConfig;
	}

	public void setPickupConfig(String pickupConfig) {
		this.pickupConfig = pickupConfig;
		// WANT to add something where:
		// Set parameters of 5 different pickup configs.. 
		// if not one of those 5 syso "contact custom shop"
	}

	public boolean isGoodForMetal() {
		return goodForMetal;
	}

	public void setGoodForMetal(boolean goodForMetal) {
		this.goodForMetal = goodForMetal;
		if(goodForMetal == true) {
			System.out.println("SLAYERRRR!!!");
			return;
		} else {
			this.goodForMetal = goodForMetal;
		}
	}

	public boolean isRoseWood() {
		return roseWood;
	}

	public void setRoseWood(boolean roseWood) {
		this.roseWood = roseWood;
		if(roseWood == false) {
			System.out.println("Thanks for saving the planet!");
			return;
		} else {
			System.out.println("Thats not very cool of you :(");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(body, goodForMetal, id, model, pickupConfig, pickups, price, roseWood, strings, year);
	}

	// HashCode and Equals:
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuitarModels other = (GuitarModels) obj;
		return Objects.equals(body, other.body) && goodForMetal == other.goodForMetal && id == other.id
				&& Objects.equals(model, other.model) && Objects.equals(pickupConfig, other.pickupConfig)
				&& Objects.equals(pickups, other.pickups)
				&& Float.floatToIntBits(price) == Float.floatToIntBits(other.price) && roseWood == other.roseWood
				&& strings == other.strings && year == other.year;
	}

	// To String
	@Override
	public String toString() {
		return "GuitarModels [id=" + id + ", strings=" + strings + ", year=" + year + ", price=" + price + ", model="
				+ model + ", body=" + body + ", pickups=" + pickups + ", pickupConfig=" + pickupConfig
				+ ", goodForMetal=" + goodForMetal + ", roseWood=" + roseWood + "]";
	}

	
	
	
	
	
	
	
	
}
