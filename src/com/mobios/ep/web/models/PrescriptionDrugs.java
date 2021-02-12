package com.mobios.ep.web.models;


public class PrescriptionDrugs {
	
	private int id;
	private String tradeName;
	private String genericName;
	private String rawName;
	private String weight;
	private String frequency;
	private int counter;
	private String duration;
	private int qty;
	private String category;
	private boolean inHouse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}
	public String getGenericName() {
		return genericName;
	}
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}
	
	public String getRawName() {
		return rawName;
	}
	public void setRawName(String rawName) {
		this.rawName = rawName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public boolean isInHouse() {
		return inHouse;
	}
	public void setInHouse(boolean inHouse) {
		this.inHouse = inHouse;
	}
	
	
}
