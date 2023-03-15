package com.velozient.drone_delivery_app.model;

public class Drone implements Comparable<Drone> {

	private String name;
	private Double maximumWeight;

	public Drone(String name, Double maximumWeight) {
		this.name = name;
		this.maximumWeight = maximumWeight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMaximumWeight() {
		return maximumWeight;
	}

	public void setMaximumWeight(Double maximumWeight) {
		this.maximumWeight = maximumWeight;
	}
	
	@Override
	public int compareTo(Drone outroDrone) {
		if (this.maximumWeight > outroDrone.getMaximumWeight()) {
			return -1;
		}
		if (this.maximumWeight < outroDrone.getMaximumWeight()) {
			return 1;
		}
		return 0;
	}

}
