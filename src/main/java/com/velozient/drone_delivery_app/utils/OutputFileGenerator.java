package com.velozient.drone_delivery_app.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.velozient.drone_delivery_app.model.Location;
import com.velozient.drone_delivery_app.model.Trip;

public class OutputFileGenerator {
	
	public static void generateOutputFile(Map<String, List<Trip>> tripsByDrone, String filePath) throws IOException {
        OutputStream os = new FileOutputStream(filePath);
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os));
        
        for (Iterator<Map.Entry<String, List<Trip>>> tripsByDroneIterator = tripsByDrone.entrySet().iterator(); tripsByDroneIterator.hasNext(); ) {
        	Entry<String, List<Trip>> entry = tripsByDroneIterator.next();
        	String droneName = entry.getKey();
        	List<Trip> droneTrips = entry.getValue();
        	int tripNumber = 1;
        	br.write("[" + droneName + "]");
        	br.newLine();
        	
        	writeDroneTrips(br, droneTrips, tripNumber);
        	
        	if (tripsByDroneIterator.hasNext()) {
        		br.newLine();
        		br.newLine();
        	}
        }
        br.close();
	}

	private static void writeDroneTrips(BufferedWriter br, List<Trip> droneTrips, int tripNumber) throws IOException {
		for (Iterator<Trip> droneTripsIterator = droneTrips.iterator(); droneTripsIterator.hasNext(); ) {
			Trip trip = droneTripsIterator.next();
			br.write("Trip #" + tripNumber);
			br.newLine();
			for (Iterator<Location> tripLocationsIterator = trip.getLocations().iterator(); tripLocationsIterator.hasNext();) {
				Location location = tripLocationsIterator.next();
				br.write("[" + location.getName() + "]");
				if (tripLocationsIterator.hasNext()) {
					br.write(",");
				}
			}
			tripNumber++;
			if (droneTripsIterator.hasNext()) {
				br.newLine();
			}
		}
	}

}
