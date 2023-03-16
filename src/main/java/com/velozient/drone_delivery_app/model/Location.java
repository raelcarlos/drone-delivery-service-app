package com.velozient.drone_delivery_app.model;

public class Location implements Comparable<Location> {

	private String name;
	private Double deliveryWeight;
	
	public Location(String name, Double deliveryWeight) {
		this.name = name;
		this.deliveryWeight = deliveryWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDeliveryWeight() {
		return deliveryWeight;
	}

	public void setDeliveryWeight(Double deliveryWeight) {
		this.deliveryWeight = deliveryWeight;
	}
	
	@Override
	public int compareTo(Location outraLocation) {
		if (this.deliveryWeight < outraLocation.getDeliveryWeight()) {
			return -1;
		}
		if (this.deliveryWeight > outraLocation.getDeliveryWeight()) {
			return 1;
		}
		return 0;
	}

}
