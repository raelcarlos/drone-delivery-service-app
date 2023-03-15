package com.velozient.drone_delivery_app.model;

import java.util.List;

public class Trip {

	private String droneName;
	private List<Location> locations;

	public Trip(String droneName, List<Location> locations) {
		this.droneName = droneName;
		this.locations = locations;
	}

	public String getDroneName() {
		return droneName;
	}

	public void setDroneName(String droneName) {
		this.droneName = droneName;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
