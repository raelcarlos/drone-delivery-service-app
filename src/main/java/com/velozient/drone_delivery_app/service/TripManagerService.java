package com.velozient.drone_delivery_app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.velozient.drone_delivery_app.model.Drone;
import com.velozient.drone_delivery_app.model.Location;
import com.velozient.drone_delivery_app.model.Trip;
import com.velozient.drone_delivery_app.utils.InputFileReader;

public class TripManagerService {
	
	private InputFileReader inputFileReader;
	private List<Drone> drones;
	private List<Location> locations;
	private HashMap<String, List<Trip>> tripsByDrone;
	
	public TripManagerService() throws IOException {
		this.drones = getInputFileReader().readDronesInfo();
		this.locations = getInputFileReader().readLocationsInfo();
		this.tripsByDrone = new HashMap<>();
	}
	
	public Map<String, List<Trip>> generateTrips() {
		while (!getLocations().isEmpty()) {
			for (Drone drone :  getDrones()) {
				List<Location> droneLocations = new ArrayList<>();
				for (int i = getLocations().size() - 1; i >= 0; i-- ) {
					Double deliveryWeight = getLocations().get(i).getDeliveryWeight();
					Double droneAvailableLoad = getAvailableLoad(drone.getMaximumWeight(), droneLocations);
					if (droneCanCarryTheSpecifiedWeight(droneAvailableLoad, deliveryWeight)) {
						droneLocations.add(getLocations().get(i));
					}
				}
				getLocations().removeAll(droneLocations);
				addTripToCurrentDrone(drone.getName(), droneLocations);
			}
		}
		return tripsByDrone;
	}

	private boolean droneCanCarryTheSpecifiedWeight(Double droneAvailableLoad, Double locationDeliveryWeight) {
		return droneAvailableLoad - locationDeliveryWeight >= 0;
	}

	private void addTripToCurrentDrone(String droneName, List<Location> droneLocations) {
		if (!droneLocations.isEmpty()) {
			if (getTripsByDrone().containsKey(droneName)) {
				getTripsByDrone().get(droneName).add(new Trip(droneName, droneLocations));
			} else {
				getTripsByDrone().put(droneName, new ArrayList<>());
				getTripsByDrone().get(droneName).add(new Trip(droneName, droneLocations));
			}
		}
	}
	
	private Double getAvailableLoad(Double droneMaximumWeight, List<Location> locations) {
		Double totalDeliveriesWeight = 0d;
		for (Location location : locations) {
			totalDeliveriesWeight += location.getDeliveryWeight();
		}
		return droneMaximumWeight - totalDeliveriesWeight;
	}
	
	private InputFileReader getInputFileReader() throws IOException {
		if (this.inputFileReader == null) {
			this.inputFileReader = new InputFileReader("src/main/resources/Input.txt");
		}
		return inputFileReader;
	}

	public List<Drone> getDrones() {
		return drones;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public Map<String, List<Trip>> getTripsByDrone() {
		return tripsByDrone;
	}

}