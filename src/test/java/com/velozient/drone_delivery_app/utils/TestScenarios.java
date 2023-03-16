package com.velozient.drone_delivery_app.utils;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.velozient.drone_delivery_app.model.Location;
import com.velozient.drone_delivery_app.model.Trip;

public class TestScenarios {
	
	public Map<String, List<Trip>> getTripByDrone() {
		Map<String, List<Trip>> tripsByDrone = new HashMap<>();
		
		Location locationA = new Location("LocationA", 100d);
		Location locationB = new Location("LocationB", 80d);
		Location locationC = new Location("LocationC", 20d);
		Location locationD = new Location("LocationD", 220d);
		Location locationE = new Location("LocationE", 70d);
		Location locationF = new Location("LocationF", 25d);
		Location locationG = new Location("LocationG", 80d);
		
		List<Location> locationsTrip1DroneA = asList(locationA, locationD, locationB);
		Trip trip1 = new Trip("DroneA", locationsTrip1DroneA);
		List<Location> locationsTrip2DroneA = asList(locationC, locationG);
		Trip trip2 = new Trip("DroneA", locationsTrip2DroneA);
		List<Trip> droneATrips = Arrays.asList(trip1, trip2);
		tripsByDrone.put("DroneA", droneATrips);
		
		List<Location> locationsTrip3DroneB = asList(locationE);
		Trip trip3 = new Trip("DroneB", locationsTrip3DroneB);
		List<Location> locationsTrip4DroneB = asList(locationF);
		Trip trip4 = new Trip("DroneB", locationsTrip4DroneB);
		
		List<Trip> droneBTrips = Arrays.asList(trip3, trip4);
		tripsByDrone.put("DroneB", droneBTrips);
		
		return tripsByDrone;
	}


}
